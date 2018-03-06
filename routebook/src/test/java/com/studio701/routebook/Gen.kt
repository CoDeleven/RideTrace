package com.studio701.routebook

import com.studio701.entity.common.ExtraInfoPoint
import com.studio701.entity.common.Point
import com.studio701.entity.routebook.Comment
import com.studio701.entity.routebook.RouteBook
import java.util.*

fun genRouteBook(): RouteBook {
    return RouteBook.Builder().setTitle("测试路书22222222222")
            .setUsedNum(0).setThumbsNumber(0)
            .setStartPoint(getExtraInfoPoint())
            .setPublishDate(Date().time)
            .setLength(1000)
            .setIsPractise(false)
            .setCoverUrl("http://ridetrace-1252749790.cossh.myqcloud.com/pic/1487202906481.jpeg")
            .setAuthorName("我是作者")
            .setAuthorId("admin")
            .setTopic("浙江一定要去爬一次的坡")
            .setMidPoint(getExtraPoints(10)).build()
}
fun genRandomDouble(scope:Int):Double{
    return Random().nextDouble() * scope
}
fun genPoint(): Point {
    return Point(genRandomDouble(100), genRandomDouble(100))
}
fun getExtraInfoPoint(): ExtraInfoPoint {
    val extraInfo = ExtraInfoPoint()
    extraInfo.urls = genExtraInfo()
    extraInfo.point = genPoint()

    return extraInfo
}
fun genExtraInfo():MutableList<String>{
    return mutableListOf("a", "b", "c")
}
fun getExtraPoints(scope:Int):List<ExtraInfoPoint>{
    val list = mutableListOf<ExtraInfoPoint>()
    for(i in 0..scope){
        list.add(getExtraInfoPoint())
    }
    return list
}
fun genComment(routeId:String): Comment {
    val comment = Comment()
    comment.belongId = routeId
    comment.userId = "testId"
    comment.username = "测试用户民"
    comment.content = "测试测试测试测试测试测试测试"
    comment.date = Date().time

    return comment
}