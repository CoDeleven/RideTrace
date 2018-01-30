package com.studio701.ride.dao

import com.studio701.ride.entity.Route
import com.studio701.ride.genRoute
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertTrue

@RunWith(SpringRunner::class)
@DataMongoTest
class RouteDaoTest {
    @Autowired
    lateinit var template:MongoTemplate

    @Test
    fun testCreateRoute(){
        val routeDao = RouteDao()
        routeDao.template = template
        routeDao.createRoute(genRoute())
    }

    @Test
    fun testQueryRoute(){
        val routeDao = RouteDao()
        routeDao.template = template
        val routes = routeDao.queryRoute("admin", 0, 10)
        println(routes)
        assertTrue {
            routes.isNotEmpty()
        }
    }
}