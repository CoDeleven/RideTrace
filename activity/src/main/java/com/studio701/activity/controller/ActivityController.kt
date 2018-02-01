package com.studio701.activity.controller

import com.studio701.activity.entity.ResponseObject
import com.studio701.activity.entity.Activity
import com.studio701.activity.service.interfaces.IActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping(path = ["/activity"])
class ActivityController {
    @Autowired
    lateinit var activityService: IActivityService
    @Autowired
    lateinit var restTemplate: RestTemplate

    @RequestMapping(path = ["/"], method = [RequestMethod.POST], consumes = ["application/json"])
    fun createActivity(@RequestBody activity: Activity): ResponseObject<String> {
        activityService.createActivity(activity)
        return ResponseObject()
    }

    @RequestMapping(path = ["/{userId}"], method = [RequestMethod.GET])
    fun queryActivity(@PathVariable("userId") userId:String, @RequestParam("skip") skip:Int, @RequestParam("num") num:Int): ResponseObject<List<Activity>> {
        return ResponseObject(activityService.queryActivity(userId, skip, num))
    }

    @RequestMapping(path = ["/enroll/{activityId}/{userId}"], method = [RequestMethod.PUT])
    fun enterActivity(@PathVariable("activityId") activityId:String, @PathVariable("userId") userId:String): ResponseObject<String> {
        activityService.enterActivity(activityId, userId)
        return ResponseObject()
    }

    @RequestMapping(path = ["/exit/{activityId}/{userId}"], method = [RequestMethod.PUT])
    fun endActivity(@PathVariable("activityId") activityId:String, @PathVariable("userId") userId:String): ResponseObject<String> {
        activityService.exitActivity(activityId, userId)
        return ResponseObject()
    }
}