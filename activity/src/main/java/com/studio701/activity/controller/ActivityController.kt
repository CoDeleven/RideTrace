package com.studio701.activity.controller

import com.studio701.activity.ResponseObject
import com.studio701.activity.entity.Activity
import com.studio701.activity.service.ActivityService
import com.studio701.activity.service.interfaces.IActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/activity"])
class ActivityController {
    @Autowired
    lateinit var activityService: IActivityService

    @RequestMapping(path = ["/"], method = [RequestMethod.PUT])
    fun createActivity(@RequestBody activity: Activity): ResponseObject<String> {
        activityService.createActivity(activity)
        return ResponseObject()
    }

    @RequestMapping(path = ["/{userId}"], method = [RequestMethod.GET])
    fun queryActivity(@PathVariable("userId") userId:String, @RequestParam("skip") skip:Int, @RequestParam("num") num:Int):ResponseObject<List<Activity>>{

        return ResponseObject(activityService.queryActivity(userId, skip, num))
    }

    @RequestMapping(path = ["/{activityId}/{userId}"])
    fun enterActivity(@PathVariable("activityId") activityId:String, @PathVariable("userId") userId:String):ResponseObject<String>{
        activityService.enterActivity(activityId, userId)

        return ResponseObject()
    }

}