package com.studio701.ridemoment.controller

import com.studio701.ridemoment.entity.ResponseObject
import com.studio701.ridemoment.entity.User
import com.studio701.ridemoment.entity.moment.BaseMoment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/moments"), consumes = arrayOf("application/json"))
class MomentOpeartorController {

    @RequestMapping(path = arrayOf("/like"), method = arrayOf(RequestMethod.PUT))
    fun likeMoment(user: User, momentId:String):ResponseObject<Object>{

        return ResponseObject()
    }
}