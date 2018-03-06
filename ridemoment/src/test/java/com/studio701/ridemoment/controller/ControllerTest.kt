package com.studio701.ridemoment.controller

import com.studio701.ridemoment.genRideMoment
import com.studio701.ridemoment.get
import com.studio701.ridemoment.post
import com.studio701.ridemoment.put
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testMomentCreated(){
        for (i in 0..2){
            post("/moments/", mockMvc, genRideMoment())
        }
    }
    @Test
    fun testMomentQuery(){
        println(get("/moments/?skip=0&num=10", mockMvc, null))
    }
    @Test
    fun testMomentLike(){
        println(put("/moments/admin/like/5a8406275fccb991a8f96ca5?skip=0&num=10", mockMvc, null))
    }
}