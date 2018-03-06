package com.studio701.ride.service.interfaces

import com.studio701.entity.User
import com.studio701.entity.ride.SimpleRideTrace
import sun.java2d.pipe.SpanShapeRenderer

interface IRideService {
    fun createTrace(route:SimpleRideTrace)
    fun queryTrace(userId:String, skip:Int, num:Int):List<SimpleRideTrace>
    fun queryOtherPeopleInActivity(activityId:String):List<String>
}