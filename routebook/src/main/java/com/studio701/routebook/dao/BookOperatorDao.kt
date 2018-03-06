package com.studio701.routebook.dao

import com.mongodb.BasicDBObject
import com.studio701.entity.routebook.Comment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class BookOperatorDao:RouteBookOperator {
    @Autowired
    lateinit var template: MongoTemplate

    companion object {
        private const val GOOD_COLLECTION_NAME = "routbook_good"
        private const val COMMENT_COLLECTION_NAME = "routebook_comment"
        private const val COLLECT_COLLECTION_NAME = "routebook_collect"
        private const val COLLECTION_NAME = "routebook"
    }

    override fun good(userId: String, routeBookId: String) {

        if(!template.collectionExists(GOOD_COLLECTION_NAME)){
            template.createCollection(GOOD_COLLECTION_NAME)
        }

        incProperty(routeBookId, "thumbsNumber")
        template.save(BasicDBObject(mapOf(Pair("userId", userId), Pair("routeBookId", routeBookId), Pair("date", Date()))), GOOD_COLLECTION_NAME)
    }

    override fun comment(comment: Comment) {
        if(!template.collectionExists(COMMENT_COLLECTION_NAME)){
            template.createCollection(COMMENT_COLLECTION_NAME)
        }
        template.save(comment, COMMENT_COLLECTION_NAME)
        incProperty(comment.belongId, "commentNumber")
    }

    override fun collect(userId: String, routeBookId: String) {
        if(!template.collectionExists(COLLECT_COLLECTION_NAME)){
            template.createCollection(COLLECT_COLLECTION_NAME)
        }
        template.save(BasicDBObject(mapOf(Pair("userId", userId), Pair("routeBookId", routeBookId), Pair("date", Date()))), COLLECT_COLLECTION_NAME)
        incProperty(routeBookId, "collectionNumber")
    }

    override fun fee(userId: String, routeBookId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun incProperty(routeBookId:String, property:String){
        template.updateFirst(Query.query(Criteria.where("_id").`is`(routeBookId)),
                Update().inc(property, 1), COLLECTION_NAME)
    }

    override fun listComments(routeBookId: String): List<Comment> {
        return template.find(Query.query(Criteria.where("belongId").`is`(routeBookId)),
                Comment::class.java, COMMENT_COLLECTION_NAME)
    }
}