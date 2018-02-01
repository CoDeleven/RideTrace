package com.studio701.activity.dao

import com.studio701.activity.dao.interfaces.ActivityRepository
import com.studio701.activity.entity.Activity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component

@Component
open class ActivityDao : ActivityRepository {
    override fun queryActivities(userId: String, skip: Int, num: Int): List<Activity> {
        return template.find(Query.query(Criteria.where("author").`is`(userId)).skip(skip).limit(num),
                Activity::class.java)
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
}