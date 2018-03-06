package com.studio701.user

import com.studio701.entity.User


fun createUser(): User {
    val user = User("admin", "测试名字", "test1", ArrayList<String>(), "http://ridetrace-1252749790.file.myqcloud.com/pic/icon-head.jpg")
    user.myRouteBookIds = listOf("RouteBOok_Id", "fdafasd")
    return user;
}