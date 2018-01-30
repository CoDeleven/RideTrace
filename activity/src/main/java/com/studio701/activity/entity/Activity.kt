package com.studio701.activity.entity

import com.studio701.ride.entity.point.Point
import java.util.*

data class Activity(
        val id:String?,
        val title:String,
        // 推广的用户
        val publishUser:String,
        val introduce:String,
        val fee:Int,
        // 封面
        val coverUrl:String,
        // 报名的人
        val registerPeople:List<String>,
        // 实际参加的人
        val enterPeople:List<String>,
        val originPoint: Point,
        val endPoint:Point,
        // 报名阶段、进行中、结束
        val status:Boolean,
        // 标签
        val tag:List<String>,
        // 创建日期
        val publishDate: Date,
        // 限制人数
        val limitNum:Int,
        // 联系电话
        val phone:String,
        // 路书Id
        val routeId:String
        )