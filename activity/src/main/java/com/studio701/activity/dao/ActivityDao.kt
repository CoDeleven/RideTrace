package com.studio701.activity.dao

import com.fasterxml.jackson.databind.ObjectMapper
import com.studio701.activity.dao.interfaces.ActivityRepository
import com.studio701.entity.activity.Activity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component

@Component
open class ActivityDao : ActivityRepository {
    override fun getDetail(activityId: String): Activity {
        return template.find(Query.query(Criteria.where("_id").`is`(activityId)),
                Activity::class.java, COLLECTION_NAME)[0]
    }

    override fun queryActivities(userId: String, skip: Int, num: Int): List<Activity> {
        if (userId.isEmpty()) {
            return template.findAll(Activity::class.java, COLLECTION_NAME)
        }
        return template.find(Query.query(Criteria.where("registerPeople").`in`(userId)).skip(skip).limit(num),
                Activity::class.java, COLLECTION_NAME)
    }

    @Autowired
    lateinit var template: MongoTemplate

    companion object {
        private const val ENTER_PEOPLE = "enterPeople"
        private const val REGISTER_PEOPLE = "registerPeople"
        private const val COLLECTION_NAME = "activity"
    }

    override fun registerActivity(userId: String, activityId: String) {
        template.updateFirst(Query.query(Criteria.where("_id").`is`(activityId)),
                Update().addToSet(REGISTER_PEOPLE, userId),
                COLLECTION_NAME)
    }

    override fun createActivity(activity: Activity) {
        if (!existCollection(COLLECTION_NAME, template)) {
            template.createCollection(COLLECTION_NAME)
        }
        template.insert(activity, COLLECTION_NAME)

    }

    override fun exitActivity(userId: String, activityId: String) {
        template.updateFirst(Query.query(Criteria.where("_id").`is`(activityId)),
                Update().pull(REGISTER_PEOPLE, userId), COLLECTION_NAME)

    }

    override fun enterActivity(userId: String, activityId: String) {
        template.updateFirst(Query.query(Criteria.where("_id").`is`(activityId)),
                Update().addToSet(ENTER_PEOPLE, userId), COLLECTION_NAME)
    }

    override fun updateActivities(activity: Activity) {
        val json = ObjectMapper().writeValueAsString(activity)
        val map = ObjectMapper().readValue(json, Map::class.java)
        val obj = Update().updateObject
        obj.putAll(map)


        template.updateFirst(Query.query(Criteria.where("_id").`is`(activity.id)),
                Update.fromDBObject(obj), COLLECTION_NAME)
    }

    override fun deleteActivity(activityId: String) {
        template.remove(Query.query(Criteria.where("_id").`is`(activityId)), COLLECTION_NAME)
    }
}