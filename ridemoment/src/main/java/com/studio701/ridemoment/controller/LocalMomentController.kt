package com.studio701.ridemoment.controller

import com.studio701.ridemoment.entity.ResponseObject
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/moments"], consumes = ["application/json"])
class LocalMomentController {

    @RequestMapping("/local/{latestNum}")
    fun getLatestMoment(@PathVariable latestNum:Int):ResponseObject<Object>{
        return ResponseObject()
    }
}