package com.studio701.ride.dao

import com.mongodb.MongoClient
import com.studio701.ride.dao.interfaces.TraceRepository
import com.studio701.ride.entity.point.Point
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
open class TraceDao : TraceRepository {
    @Autowired
    lateinit var client: MongoClient
    @Autowired
    lateinit var template: MongoTemplate

    companion object {
        private const val COLLECTION_NAME:String = "trace"
    }

    override fun initLocation(point: Point): String {
        if(!existCollection(COLLECTION_NAME, template)){
            template.createCollection(COLLECTION_NAME)
        }
        template.save(point, COLLECTION_NAME)
        return ""
    }

    override fun saveLocation(point: Point, traceId:String) {

    }

    override fun saveLocations(points: List<Point>, traceId:String) {
        points.forEach {
            saveLocation(it, traceId)
        }
    }
}
