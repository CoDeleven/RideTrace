package com.studio701.routebook.dao

import com.studio701.entity.routebook.Comment


interface RouteBookOperator {
    fun good(userId:String, routeBookId:String)
    fun comment(comment: Comment)
    fun collect(userId:String, routeBookId: String)
    fun fee(userId: String, routeBookId: String)
    fun listComments(routeBookId:String):List<Comment>
}