package com.studio701.ride.dao

import com.studio701.entity.ride.SimpleRideTrace
import com.studio701.ride.dao.interfaces.RouteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
open class RouteDao : RouteRepository {
    @Autowired
    lateinit var template: MongoTemplate

    override fun queryRoute(userId: String, skip: Int, num: Int): List<SimpleRideTrace> {
        return template.find(
                Query.query(Criteria.where("authorId").`is`(userId)).skip(skip).limit(num),
                SimpleRideTrace::class.java, COLLECTION_NAME)
    }

    companion object {
        private const val COLLECTION_NAME = "trace"
    }

    override fun createRoute(route: SimpleRideTrace) {
        if (!existCollection(COLLECTION_NAME, template)) {
            template.createCollection(COLLECTION_NAME)
        }
        template.save(route, COLLECTION_NAME)
    }

    override fun queryOtherInfoInActivity(activityId: String): List<String> {
        val query = Query()
        query.fields().include("authorId")
        query.addCriteria(Criteria.where("orgId").`is`(activityId))
        val foo = template.find(query, HashMap::class.java, COLLECTION_NAME)
        val ids = mutableListOf<String>()

        foo.forEach {
            ids.add(it["authorId"] as String)
        }


        return ids
    }
}