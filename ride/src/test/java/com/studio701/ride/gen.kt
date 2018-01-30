package com.studio701.ride

import com.studio701.ride.entity.Route
import com.studio701.ride.entity.point.ExtraInfoPoint
import com.studio701.ride.entity.point.Point
import sun.awt.windows.ThemeReader.getPoint
import java.util.*
import kotlin.collections.HashMap

fun genRoute(): Route {
    return Route(publishUser = "admin",
            originPoint = genPoint(),
            destPoint = genPoint(),
            date = Date(),
            trace = getExtraPoints(3000),
            totalDistance = genRandomDouble(100),
            avgSpeed = genRandomDouble(40),
            prestissimo = genRandomDouble(1000),
            consumeTime = 1000
            )
}
fun genRandomDouble(scope:Int):Double{
    return Random().nextDouble() * scope
}
fun genPoint():Point{
    return Point(genRandomDouble(100), genRandomDouble(100))
}
fun getExtraInfoPoint():ExtraInfoPoint{
    return ExtraInfoPoint(genExtraInfo(), genPoint())
}
fun getExtraPoints(scope:Int):List<ExtraInfoPoint>{
    val list = mutableListOf<ExtraInfoPoint>()
    for(i in 0..scope){
        list.add(getExtraInfoPoint())
    }
    return list
}
fun genExtraInfo():Map<ExtraInfoPoint.InfoType, List<String>>{
    return mapOf(Pair(ExtraInfoPoint.InfoType.PHOTO, listOf("a", "b", "c")))
}
fun genActivityGroup(peopleNum:Int):Map<String, Point>{
    val peopleMap = mutableMapOf<String, Point>()
    for(i in 0..peopleNum){
        peopleMap["peopleId:$i"] = genPoint()
    }
    return peopleMap
}