package com.studio701.ride.controller

import com.studio701.ride.entity.ResponseObject
import com.studio701.ride.entity.Route
import com.studio701.ride.service.interfaces.IRideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/ride-single"])
class RideSingleController {
    enum class MatrixQueryKey(val label:String){
        PAGE("page"), SIZE("size"), USER_ID("userId")
    }
    @Autowired
    lateinit var rideService: IRideService

    @RequestMapping(path = ["/trace"], method = [RequestMethod.PUT])
    fun createRoute(route:Route): ResponseObject<String> {
        rideService.createTrace(route)
        return ResponseObject()
    }

    @RequestMapping(path = ["/trace/{userId}"], method = [RequestMethod.GET])
    fun getTrace(@PathVariable("userId") userId:String, @RequestParam("page") page:Int, @RequestParam("perPageSize") perPageSize:Int): ResponseObject<List<Route>> {
        if(page < 1){
            return ResponseObject(400, "Bad Request: The Page Number Must Greater Than Zero.")
        }

        return ResponseObject(rideService.queryTrace(userId, (page - 1) * perPageSize, perPageSize))
    }
}