package com.studio701.activity

import com.studio701.entity.activity.Activity
import com.studio701.entity.common.Point
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
            "路书封面",
            listOf("admin"),
            listOf(),
            genPoint(),
            Date(),
            0,
            listOf(),
            Date(),
            Date(),
            1000,
            "手机",
            "测试路书ID",
            10,
            100.0

    )
}