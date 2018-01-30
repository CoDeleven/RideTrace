package com.studio701.activity.dao.interfaces

import com.studio701.activity.entity.Activity

interface ActivityRepository: BaseRepository {
    fun registerActivity(userId:String, activityId:String)
    fun exitActivity(userId:String, activityId:String)
    fun enterActivity(userId:String, activityId:String)
    fun createActivity(activity:Activity)
    fun queryActivities(userId:String, skip:Int, num:Int):List<Activity>
}