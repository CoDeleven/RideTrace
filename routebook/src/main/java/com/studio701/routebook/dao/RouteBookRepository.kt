package com.studio701.routebook.dao

import com.studio701.entity.routebook.RouteBook
import org.springframework.cloud.netflix.zuul.filters.Route


interface RouteBookRepository:BaseRepository {
    fun createRouteBook(routeBook: RouteBook)
    fun deletePicFromRouteBook(picUrl:String, routeBookId:String)
    fun queryRouteBook(userId:String, skip:Int, num:Int):List<RouteBook>
    fun updateRouteBook(routeBook: RouteBook)
    fun queryRouteBookByTopic(topic:String):List<RouteBook>
    fun listAllTopic():List<*>
    fun listRouteBookIdList(routeBookId:List<String>):List<RouteBook>
    fun queryRouteBook(routeBookId: String):RouteBook
    fun listCollectionRouteBook(userId: String): List<RouteBook>?
}