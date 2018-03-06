package com.studio701.routebook.service.interfaces

import com.studio701.entity.routebook.RouteBook


interface IRouteBookService {
    fun createRouteBook(routeBook: RouteBook)
    fun deletePicFromBook(routeBookId:String, desiredDeleteUrl:String)
    fun listRouteBooks(userId:String, skip:Int, num:Int):List<RouteBook>
    fun deleteRouteBook(routeBookId: String)
    fun updateRouteBook(routeBook:RouteBook)
    fun listTopicBooks(topic: String): List<RouteBook>
    fun listAllTopic():List<String>
    fun listRouteBooks(routeBookId:List<String>):List<RouteBook>
    fun queryDetailBook(routeBookId: String):RouteBook
    fun listMyRouteBook(userId: String): List<RouteBook>?
}