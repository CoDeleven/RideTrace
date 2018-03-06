package com.studio701.activity.service

import com.studio701.activity.dao.interfaces.ActivityRepository
import com.studio701.activity.service.interfaces.IActivityService
import com.studio701.entity.activity.Activity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActivityService : IActivityService {
    override fun getDetailActivity(activityId: String): Activity? {
        return activityDao.getDetail(activityId)
    }

    @Autowired
    lateinit var activityDao: ActivityRepository

    override fun createActivity(activity: Activity) {
        activityDao.createActivity(activity)
    }

    override fun queryActivity(userId: String, skip: Int, num: Int): List<Activity> {
        return activityDao.queryActivities(userId, skip, num)
    }

    override fun enterActivity(activityId: String, userId: String) {
        activityDao.enterActivity(userId, activityId)
    }

    override fun exitActivity(activityId: String, userId: String) {
        activityDao.exitActivity(userId, activityId)
    }

    override fun updateActivity(activity: Activity) {
        activityDao.updateActivities(activity)
    }

    override fun deleteActivity(activityId: String) {
        activityDao.deleteActivity(activityId)
    }

    override fun registerActivity(activityId: String, userId: String) {
        activityDao.registerActivity(userId, activityId)
    }
}