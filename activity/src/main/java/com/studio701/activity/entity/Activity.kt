package com.studio701.activity.entity

import com.studio701.activity.annotations.Kako
import com.studio701.ride.entity.point.Point
import java.util.*
enum class ActivityStatus{
        REGISTER_TIME, RIDING_TIME, END_TIME
}

@Kako
data class Activity(
        var id:String?,
        var title:String,
        // 作者
        var author:String,
        var introduce:String,
        var fee:Int,
        // 封面
        var coverUrl:String,
        // 报名的人
        var registerPeople:List<String>,
        // 实际参加的人
        var enterPeople:List<String>,
        var originPoint: Point,
        var endPoint:Point,
        // 报名阶段、进行中、结束
        var status:ActivityStatus,
        // 标签
        var tag:List<String>,
        // 创建日期
        var publishDate: Date,
        // 开始日期
        var startDate:Date,
        // 限制人数
        var limitNum:Int,
        // 联系电话
        var phone:String,
        // 路书Id
        var routeId:String
        )