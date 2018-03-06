package com.studio701.ride.dao.interfaces

import com.studio701.entity.User
import com.studio701.entity.ride.SimpleRideTrace

interface RouteRepository :BaseRepository {
    fun createRoute(route: SimpleRideTrace)
    fun queryRoute(userId:String, skip:Int, num:Int):List<SimpleRideTrace>
    fun queryOtherInfoInActivity(activityId:String):List<String>
}