package com.studio701.ride.service

import com.studio701.entity.User
import com.studio701.entity.ride.SimpleRideTrace
import com.studio701.ride.dao.interfaces.RouteRepository
import com.studio701.ride.service.interfaces.IRideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RideService : IRideService {
    override fun queryTrace(userId: String, skip: Int, num: Int): List<SimpleRideTrace> {
        return routeDao.queryRoute(userId, skip, num)
    }

    override fun createTrace(route: SimpleRideTrace) {
        routeDao.createRoute(route)
    }

    @Autowired
    lateinit var routeDao: RouteRepository

    override fun queryOtherPeopleInActivity(activityId: String): List<String> {
        return routeDao.queryOtherInfoInActivity(activityId)
    }

}