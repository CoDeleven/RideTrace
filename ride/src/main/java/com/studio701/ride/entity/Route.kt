package com.studio701.ride.entity

import com.studio701.ride.entity.point.ExtraInfoPoint
import com.studio701.ride.entity.point.Point
import java.util.*

data class Route(
        val id:String? = null,
        // 用户ID
        val publishUser:String,
        // 起始地点
        val originPoint: Point,
        // 目标地点
        val destPoint: Point,
        // 开始时间
        val date: Date,
        // 每个位置的额外信息
        val trace:List<ExtraInfoPoint>,
        // 总骑行距离
        val totalDistance:Double,
        // 平均行驶速度
        val avgSpeed:Double,
        // 最高行驶速度
        val prestissimo:Double,
        // 花费的时间,单位秒
        val consumeTime:Int
        )