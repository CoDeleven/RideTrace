package com.studio701.routebook.service

import com.studio701.entity.routebook.RouteBook
import com.studio701.routebook.dao.RouteBookOperator
import com.studio701.routebook.dao.RouteBookRepository
import com.studio701.routebook.service.interfaces.IRouteBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.netflix.zuul.filters.Route
import org.springframework.stereotype.Service

@Service
class RouteBookService:IRouteBookService {

    @Autowired
    lateinit var routeBookDao:RouteBookRepository

    override fun listMyRouteBook(userId: String): List<RouteBook>? {
        return routeBookDao.listCollectionRouteBook(userId)
    }

    override fun queryDetailBook(routeBookId: String): RouteBook {
        return routeBookDao.queryRouteBook(routeBookId)
    }
//    @Autowired
//    lateinit var routeBookOperatorDao:RouteBookOperator


    override fun createRouteBook(routeBook: RouteBook) {

        routeBookDao.createRouteBook(routeBook)
    }

    override fun deletePicFromBook(routeBookId: String, desiredDeleteUrl: String) {
//        routeBookDao.deletePicFromRouteBook(desiredDeleteUrl, routeBookId)
    }

    override fun listRouteBooks(userId:String, skip: Int, num: Int):List<RouteBook> {
        return routeBookDao.queryRouteBook(userId, skip, num)
    }

    override fun deleteRouteBook(routeBookId: String) {

    }

    override fun updateRouteBook(routeBook: RouteBook) {
        routeBookDao.updateRouteBook(routeBook)
    }

    override fun listTopicBooks(topic: String):List<RouteBook> {
        return routeBookDao.queryRouteBookByTopic(topic)
    }

    override fun listAllTopic(): List<String> {
        return routeBookDao.listAllTopic() as List<String>
    }

    override fun listRouteBooks(routeBookId: List<String>):List<RouteBook> {
        return routeBookDao.listRouteBookIdList(routeBookId)
    }


}