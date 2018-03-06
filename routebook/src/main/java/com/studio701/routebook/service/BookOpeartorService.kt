package com.studio701.routebook.service

import com.studio701.entity.routebook.Comment
import com.studio701.routebook.dao.RouteBookOperator
import com.studio701.routebook.service.interfaces.IRouteOperatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookOpeartorService:IRouteOperatorService {
    @Autowired
    private lateinit var operatorDao:RouteBookOperator

    override fun good(userId: String, routeBookId: String) {
        operatorDao.good(userId, routeBookId)
    }

    override fun comment(comment: Comment) {
        operatorDao.comment(comment)
    }

    override fun collect(userId: String, routeBookId: String) {
        operatorDao.collect(userId, routeBookId)
    }

    override fun listComments(routeBookId:String): List<Comment> {
        return operatorDao.listComments(routeBookId)
    }
}