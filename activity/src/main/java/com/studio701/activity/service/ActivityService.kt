package com.studio701.activity.service

import com.studio701.activity.dao.ActivityDao
import com.studio701.activity.dao.interfaces.ActivityRepository
import com.studio701.activity.entity.Activity
import com.studio701.activity.service.interfaces.IActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class ActivityService: IActivityService {

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
}