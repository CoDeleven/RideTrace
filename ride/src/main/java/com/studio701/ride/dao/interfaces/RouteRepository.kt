package com.studio701.ride.dao.interfaces

import com.studio701.ride.entity.Route

interface RouteRepository :BaseRepository {
    fun createRoute(route:Route)
    fun queryRoute(userId:String, skip:Int, num:Int):List<Route>
}