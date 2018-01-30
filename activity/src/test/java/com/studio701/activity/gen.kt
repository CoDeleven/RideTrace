package com.studio701.activity

import com.studio701.activity.entity.Activity
import com.studio701.ride.entity.point.Point
import java.util.*

fun genRandomDouble(scope:Int):Double{
    return Random().nextDouble() * scope
}
fun genPoint(): Point {
    return Point(genRandomDouble(100), genRandomDouble(100))
}
fun genActivity():Activity{
    return Activity(
            null,
            "测试活动",
            "admin",
            "测试介绍测试介绍测试介绍",
            100,
            "封面测试",
            listOf("admin"),
            listOf(),
            genPoint(),
            genPoint(),
            false,
            listOf(),
            Date(),
            5,
            "手机账号测试",
            "测试路书ID"
    )
}