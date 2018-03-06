package com.studio701.ridemoment.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.studio701.entity.common.ResponseObject
import com.studio701.entity.User
import com.studio701.entity.moment.Comment
import com.studio701.entity.moment.FavoriteItem
import com.studio701.ridemoment.dao.MomentDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.util.*

@RestController
@RequestMapping(path = ["/moments"], consumes = ["application/json"])
class MomentOperatorController {
    @Autowired
    lateinit var momentOperatorDao:MomentDao

    @Autowired
    lateinit var restTemplate: RestTemplate

    @RequestMapping(path = ["{userId}/like/{momentId}"], method = [(RequestMethod.PUT)])
    fun likeMoment(@RequestBody favoriteItem: FavoriteItem, @PathVariable("momentId") momentId:String): ResponseObject<FavoriteItem> {
        momentOperatorDao.likeMoment(momentId, favoriteItem)
        return ResponseObject(favoriteItem)
    }

    @RequestMapping(path = ["/{momentId}/comment"], method = [RequestMethod.PUT])
    fun commentMoment(@PathVariable("momentId") momentId:String, @RequestBody comment: Comment):ResponseObject<String>{
        momentOperatorDao.commentMoment(momentId, comment)
        return ResponseObject()
    }


}