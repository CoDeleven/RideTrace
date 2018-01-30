package com.studio701.ride.controller

import com.studio701.ride.ResponseObject
import com.studio701.ride.entity.point.Point
import com.studio701.ride.service.interfaces.IRideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/ride-activity"])
class RideActivityController {
    @Autowired
    lateinit var rideService: IRideService

    @RequestMapping(path = ["/enter/{activityId}"], method = [RequestMethod.POST])
    fun updateLocation(@RequestParam("userId") userId:String,
                       @PathVariable("activityId") activityId:String,
                       @RequestBody point: Point):ResponseObject<Map<String, Point>?>{
        val otherPoint = rideService.uploadLocation(activityId, userId, point)
        return ResponseObject(otherPoint)
    }
}