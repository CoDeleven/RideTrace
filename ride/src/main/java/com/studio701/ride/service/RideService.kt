package com.studio701.ride.service

import com.studio701.ride.dao.interfaces.RouteRepository
import com.studio701.ride.dao.interfaces.TraceRepository
import com.studio701.ride.entity.Route
import com.studio701.ride.entity.point.Point
import com.studio701.ride.service.interfaces.IRideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class RideService : IRideService {
    private val activityMap: MutableMap<String, MutableMap<String, Point>> = ConcurrentHashMap()
    override fun queryTrace(userId: String, skip: Int, num: Int): List<Route> {
        return routeDao.queryRoute(userId, skip, num)
    }

    override fun uploadLocation(activityId: String, userId: String, point: Point): Map<String, Point>? {
        if (!activityMap.containsKey(activityId)) {
            activityMap[activityId] = HashMap()
        }
        activityMap[activityId]!![userId] = point
        return activityMap[activityId]
    }

    @Autowired
    lateinit var traceDao: TraceRepository
    @Autowired
    lateinit var routeDao: RouteRepository

    override fun createTrace(route: Route) {
        routeDao.createRoute(route)
    }

}