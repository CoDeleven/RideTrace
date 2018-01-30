package com.studio701.ride.service.interfaces

import com.studio701.ride.entity.point.Point
import com.studio701.ride.entity.Route

interface IRideService {
    fun createTrace(route:Route)
    fun queryTrace(userId:String, skip:Int, num:Int):List<Route>
    fun uploadLocation(activityId:String, userId:String, point:Point):Map<String, Point>?
}