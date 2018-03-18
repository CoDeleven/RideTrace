package com.studio701.ridemoment.dao

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.BasicDBObject
import com.studio701.entity.moment.Comment
import com.studio701.entity.moment.FavoriteItem
import com.studio701.entity.moment.Moment
import org.apache.http.util.TextUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
open class MomentDao {
    @Autowired
    lateinit var template: MongoTemplate

    companion object {
        private const val MOMENT_COLLECTION_NAME = "moment"
//        private const val MOMENT_LIKE_COLLECTION_NAME = "moment_good"
//        private const val MOMENT_COMMENT_COLLECTION_NAME = "moment_comment"
    }

    fun createMoment(moment: Moment){
        if(!template.collectionExists(MOMENT_COLLECTION_NAME)){
            template.createCollection(MOMENT_COLLECTION_NAME)
        }
        template.insert(moment, MOMENT_COLLECTION_NAME)
    }

    fun queryMoment(userId:String, skip:Int, num:Int):List<Moment>{
        if(TextUtils.isEmpty(userId)){
            return template.find(Query().skip(skip).limit(num), Moment::class.java, MOMENT_COLLECTION_NAME)
        }
        return template.find(Query.query(Criteria.where("userId").`is`(userId)).skip(skip).limit(num), Moment::class.java, MOMENT_COLLECTION_NAME).reversed()
    }

    fun updateMoment(moment:Moment){
        val json = ObjectMapper().writeValueAsString(moment)
        val map = ObjectMapper().readValue(json, Map::class.java)
        val obj = Update().updateObject
        obj.putAll(map)

        template.updateFirst(Query.query(Criteria.where("_id").`is`(moment.id)),
                Update.fromDBObject(obj), MOMENT_COLLECTION_NAME)
    }


    fun likeMoment(momentId: String, favoriteItem: FavoriteItem){
        val update = Update().addToSet("favorites", favoriteItem)
        template.upsert(Query.query(Criteria.where("_id").`is`(momentId)),
                update, MOMENT_COLLECTION_NAME)
    }

    fun commentMoment(momentId:String, comment: Comment){
        val update = Update()
        update.addToSet("comments", comment)
        template.upsert(Query.query(Criteria.where("_id").`is`(momentId)), update, MOMENT_COLLECTION_NAME)
    }

    fun deleteLike(momentId: String, userId: String) {
        val obj = BasicDBObject()
        obj.put("userId", userId)
        template.updateFirst(
                Query.query(Criteria.where("_id").`is`(momentId)),
                Update().pull("favorites", obj),
                MOMENT_COLLECTION_NAME
        )
    }
}