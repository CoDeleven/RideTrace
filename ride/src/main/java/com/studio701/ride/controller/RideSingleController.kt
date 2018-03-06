package com.studio701.ride.controller

import com.studio701.entity.common.ResponseObject
import com.studio701.entity.ride.SimpleRideTrace
import com.studio701.ride.service.interfaces.IRideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping(path = ["/ride"])
class RideSingleController {

    @Autowired
    lateinit var template: RestTemplate

    @Autowired
    lateinit var rideService: IRideService

    @RequestMapping(path = ["/"], method = [RequestMethod.POST])
    fun createRoute(route: SimpleRideTrace): ResponseObject<String> {
        rideService.createTrace(route)
        return ResponseObject()
    }

    @RequestMapping(path = ["/{userId}"], method = [RequestMethod.GET])
    fun getTrace(@PathVariable("userId") userId: String, @RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<SimpleRideTrace>> {
        return ResponseObject(rideService.queryTrace(userId, skip, num))
    }

    @RequestMapping(path = ["/activities/{activityId}"], method = [RequestMethod.GET])
    fun getOtherInfoInActivity(@PathVariable("activityId") activityId: String): ResponseObject<*> {
        val ids = rideService.queryOtherPeopleInActivity(activityId)
        var url = ""
        ids.forEach {
            url += (it + "&")
        }

        val response = template.getForEntity("http://RIDETRACE-USER/user/more/${url.substring(0, url.length - 1)}",
                ResponseObject::class.java)
        return response.body
    }

    @RequestMapping(path = ["/test/{activityId}"], method = [RequestMethod.GET])
    fun test(@PathVariable("activityId") activityId: String): ResponseObject<*> {

        val response = template.getForEntity("http://RIDETRACE-USER/user/more/admin",
                ResponseObject::class.java)
        return response.body
    }
}