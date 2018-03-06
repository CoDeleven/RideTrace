package com.studio701.activity.service.interfaces

import com.studio701.entity.activity.Activity


interface IActivityService {
    fun createActivity(activity: Activity)
    fun queryActivity(userId:String, skip:Int, num:Int):List<Activity>
    fun enterActivity(activityId:String, userId:String)
    fun exitActivity(activityId:String, userId:String)
    fun updateActivity(activity: Activity)
    fun deleteActivity(activityId: String)
    fun registerActivity(activityId:String, userId:String)
    fun getDetailActivity(activityId: String): Activity?
}