package com.studio701.activity.controller

import com.studio701.activity.service.interfaces.IActivityService
import com.studio701.entity.activity.Activity
import com.studio701.entity.common.ResponseObject
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

    @RequestMapping(path = ["/"], method = [RequestMethod.POST])
    fun createActivity(@RequestBody activity: Activity): ResponseObject<String> {
        activityService.createActivity(activity)
        return ResponseObject()
    }

    @RequestMapping(path = ["/{userId}"], method = [RequestMethod.GET])
    fun queryActivity(@PathVariable("userId") userId: String, @RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<Activity>> {
        return ResponseObject(activityService.queryActivity(userId, skip, num))
    }

    @RequestMapping(path = ["/detail/{activityId}"], method = [RequestMethod.GET])
    fun getActivityDetail(@PathVariable("activityId") activityId: String):ResponseObject<Activity?>{
        return ResponseObject(activityService.getDetailActivity(activityId))
    }

    @RequestMapping(path = ["/"], method = [RequestMethod.GET])
    fun queryActivity(@RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<Activity>> {
        return ResponseObject(activityService.queryActivity("", skip, num))
    }

    @RequestMapping(path = ["/enroll/{activityId}/{userId}"], method = [RequestMethod.PUT])
    fun enterActivity(@PathVariable("activityId") activityId: String, @PathVariable("userId") userId: String): ResponseObject<String> {
        activityService.enterActivity(activityId, userId)
        return ResponseObject()
    }

    @RequestMapping(path = ["/registerActivity/{activityId}/{userId}"], method = [RequestMethod.PUT])
    fun registerActivity(@PathVariable("activityId") activityId: String, @PathVariable("userId") userId: String): ResponseObject<String> {
        activityService.registerActivity(activityId, userId)
        return ResponseObject()
    }

    @RequestMapping(path = ["/exit/{activityId}/{userId}"], method = [RequestMethod.PUT])
    fun endActivity(@PathVariable("activityId") activityId: String, @PathVariable("userId") userId: String): ResponseObject<String> {
        activityService.exitActivity(activityId, userId)
        return ResponseObject()
    }

    @RequestMapping(path = ["/"], method = [RequestMethod.PUT])
    fun editActivity(@RequestBody activity: Activity): ResponseObject<String> {
        activityService.updateActivity(activity)
        return ResponseObject()
    }

    @RequestMapping(path = ["/{activityId}"], method = [RequestMethod.DELETE])
    fun deleteActivity(@PathVariable("activityId") activityId: String): ResponseObject<String> {
        activityService.deleteActivity(activityId = activityId)

        return ResponseObject()
    }
}