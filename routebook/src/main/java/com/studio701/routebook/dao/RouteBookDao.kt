package com.studio701.routebook.dao

import com.fasterxml.jackson.databind.ObjectMapper
import com.studio701.entity.routebook.RouteBook
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
open class RouteBookDao : RouteBookRepository {
    override fun queryRouteBook(routeBookId: String): RouteBook {
        val list = template.find(Query.query(Criteria.where("_id").`is`(routeBookId)), RouteBook::class.java, COLLECTION_NAME)
        return list[0];
    }

    @Autowired
    lateinit var template: MongoTemplate

    companion object {
        private const val COLLECTION_NAME = "routebook"
    }

    override fun createRouteBook(routeBook: RouteBook) {
        if (!existCollection(COLLECTION_NAME, template)) {
            template.createCollection(COLLECTION_NAME)
        }
        template.save(routeBook, COLLECTION_NAME)
    }

    override fun deletePicFromRouteBook(picUrl: String, routeBookId: String) {

    }

    override fun queryRouteBook(userId: String, skip: Int, num: Int): List<RouteBook> {
        return template.find(Query.query(Criteria.where("authorId").`is`(userId)), RouteBook::class.java, COLLECTION_NAME)
    }

    override fun updateRouteBook(routeBook: RouteBook) {
        val json = ObjectMapper().writeValueAsString(routeBook)
        val map = ObjectMapper().readValue(json, Map::class.java)
        val obj = Update().updateObject
        obj.putAll(map)

        template.updateFirst(Query.query(Criteria.where("_id").`is`(routeBook.id)),
                Update.fromDBObject(obj), COLLECTION_NAME)
    }

    override fun queryRouteBookByTopic(topic: String): List<RouteBook> {
        return template.find(Query.query(Criteria.where("topic").`is`(topic)), RouteBook::class.java, COLLECTION_NAME)
    }


    override fun listAllTopic(): List<*> {
        return template.getCollection(COLLECTION_NAME).distinct("topic")
    }

    override fun listRouteBookIdList(routeBookId: List<String>): List<RouteBook> {
        return template.find(Query.query(Criteria.where("_id").`in`(routeBookId)), RouteBook::class.java, COLLECTION_NAME)
    }

    override fun listCollectionRouteBook(userId: String): List<RouteBook>? {
        val query = Query()
        query.fields().include("routeBookId")
        query.addCriteria(Criteria.where("userId").`is`(userId))
        val foo = template.find(query, HashMap::class.java, "routebook_collect")
        val ids = mutableListOf<String>()

        foo.forEach {
            ids.add(it["routeBookId"] as String)
        }

        return template.find(Query.query(Criteria.where("_id").`in`(ids)), RouteBook::class.java, "routebook")
    }
}