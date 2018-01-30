package com.studio701.activity.dao

import com.studio701.activity.dao.interfaces.ActivityRepository
import com.studio701.activity.genActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ActivityDaoTest {
    @Autowired
    lateinit var activityDao: ActivityRepository

    @Test
    fun testActivityCreated() {
        activityDao.createActivity(genActivity())
    }

    @Test
    fun testActivityRegistered() {
        activityDao.registerActivity("testRegistered1", "5a703ba80688e921688fad88")
    }

    @Test
    fun testActivityEntered() {
        activityDao.enterActivity("admin", "5a703ba80688e921688fad88")
    }
}