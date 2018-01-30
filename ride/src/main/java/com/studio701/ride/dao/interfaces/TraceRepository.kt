package com.studio701.ride.dao.interfaces

import com.studio701.ride.entity.point.Point

interface TraceRepository :BaseRepository {
    /**
     * 保存具体位置
     * @param point 位置信息
     */
    fun saveLocation(point: Point, traceId:String)

    /**
     * 保存给定所有位置
     * @param points 一系列位置信息
     */
    fun saveLocations(points:List<Point>, traceId:String)

    /**
     * 根据point初始化位置信息
     * @param point
     */
    fun initLocation(point: Point): String
}