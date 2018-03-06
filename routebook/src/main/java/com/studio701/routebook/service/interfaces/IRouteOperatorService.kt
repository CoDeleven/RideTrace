package com.studio701.routebook.service.interfaces

import com.studio701.entity.routebook.Comment


interface IRouteOperatorService {
    fun good(userId:String, routeBookId:String)
    fun comment(comment: Comment)
    fun collect(userId:String, routeBookId: String)
    fun listComments(routeBookId:String):List<Comment>
}