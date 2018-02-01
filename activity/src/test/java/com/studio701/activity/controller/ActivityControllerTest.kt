package com.studio701.activity.controller

import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.JsonObject
import com.mongodb.util.JSON
import com.studio701.activity.*
import com.studio701.activity.entity.Activity
import com.studio701.activity.entity.ResponseObject
import junit.framework.Assert.assertTrue
import org.apache.commons.collections.map.MultiValueMap
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ActivityControllerTest {
    @Autowired
    lateinit var mockMvc:MockMvc

    @Test
    fun testActivityCreated(){
        assertEquals(ObjectMapper().writeValueAsString(ResponseObject<String>()), post("/activity/", mockMvc, genActivity()))
    }

    @Test
    fun testActivityEnter(){
        val url = "/activity/enroll/5a72c2efc54b318f7c3d32c1/admin"
        assertEquals(ObjectMapper().writeValueAsString(ResponseObject<String>()), put(url, mockMvc, null))
    }

    @Test
    fun testActivityQuery(){
        val url = "/activity/admin?skip=0&num=10"
        val data = ObjectMapper().readValue(get(url, mockMvc, null), ResponseObject::class.java).data
        println(data)
        assertTrue(data != null)
    }

    @Test
    fun testActivityExit(){
        val url = "/activity/exit/5a72c2efc54b318f7c3d32c1/admin"

        assertEquals(ObjectMapper().writeValueAsString(ResponseObject<String>()), put(url, mockMvc, null))
    }
}