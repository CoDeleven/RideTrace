package com.studio701.ride.service

import com.studio701.ride.genActivityGroup
import com.studio701.ride.genPoint
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import java.io.File

@RunWith(SpringRunner::class)
@SpringBootTest
class RideServiceTest {
    @Autowired
    lateinit var service:RideService

    @Test
    fun testUploadLocation(){
        var count = 10
        while(count-- > 0){
            for(i in 0..10){
                Task("userId:$i", "12345", service).start()
            }
            Thread.sleep(1000)
        }

    }

    @Test
    fun test2(){
        val file = File("C:\\Users\\CoDeleven\\Desktop\\Data.txt")
        val sb = StringBuilder()
        for (i in 0..10000) {
            sb.appendln("Object ref$i = a;")
        }
        file.writeText(sb.toString(), Charsets.UTF_8)
    }


    class Task(val userId:String, val activityId:String, val service:RideService):Thread(){
        override fun run() {
            super.run()
            Thread.sleep((100 * Math.random()).toLong())
            println(service.uploadLocation(activityId, userId, genPoint()))
        }
    }
}