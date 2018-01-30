package com.studio701.ride.dao

import com.mongodb.util.JSON
import com.studio701.ride.dao.interfaces.RouteRepository
import com.studio701.ride.entity.Route
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
open class RouteDao : RouteRepository {
    @Autowired
    lateinit var template: MongoTemplate

    override fun queryRoute(userId:String, skip:Int, num:Int): List<Route> {
        return template.find(
                Query.query(Criteria.where("publishUser").`is`(userId)).skip(skip).limit(num),
                Route::class.java, COLLECTION_NAME)
    }

    companion object {
        private const val COLLECTION_NAME = "trace"
    }

    override fun createRoute(route: Route) {
        if (!existCollection(COLLECTION_NAME, template)) {
            template.createCollection(COLLECTION_NAME)
        }
        template.save(route, COLLECTION_NAME)
    }
}