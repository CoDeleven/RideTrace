package com.studio701.ridemoment

import com.studio701.entity.moment.Moment
import java.util.*

fun genRandomDouble(scope: Int): Double {
    return Random().nextDouble() * scope
}

fun genRideMoment(): Moment {
    return Moment(
    ).setUserId("admin")
            .setAvator("http://ridetrace-1252749790.file.myqcloud.com/pic/icon-head2.jpg")
            .setContent("我是测试内容~~~我是测试内容~~~我是测试内容~~~我是测试内容~~~我是测试内容~~~")
            .setCreateTime(Date().time)
            .setType("2")
            .setUserName("汪汪汪")
}