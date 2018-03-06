package com.studio701.ridemoment.dao

import com.studio701.entity.match.Match
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
open class MatchDao {
    @Autowired
    lateinit var template:MongoTemplate

    companion object {
        private const val COLLECTION_NAME = "match"
    }

    fun getListMatch():List<Match>{
        return template.find(Query().skip(0).limit(30), Match::class.java, COLLECTION_NAME).reversed()
    }
}