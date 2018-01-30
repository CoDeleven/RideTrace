package com.studio701.ride.dao.interfaces

import org.springframework.data.mongodb.core.MongoTemplate

interface BaseRepository {
    fun existCollection(collection:String, template:MongoTemplate):Boolean{
        return template.collectionExists(collection)
    }
}