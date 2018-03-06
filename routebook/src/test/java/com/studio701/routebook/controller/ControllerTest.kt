package com.studio701.routebook.controller

import com.studio701.routebook.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    lateinit var mockmvc:MockMvc

    @Test
    fun testRouteBookCreated(){
        post("/route-book/", mockmvc, genRouteBook())
    }

    @Test
    fun testRouteQuery(){
        get("/route-book/", mockmvc, mapOf(Pair("skip", listOf("0")), Pair("num", listOf("10"))))
    }

    @Test
    fun testRouteBookGood(){
        put("/route-book/good/admin/5a798ca7db90f529b4834b96", mockmvc, null)
    }

    @Test
    fun testRouteBookCollection(){
        put("/route-book/collect/admin/5a798ca7db90f529b4834b96", mockmvc, null)
    }

    @Test
    fun testRouteBookComment(){
        val routeBookId = "5a858790c37fe3000c468d19"
        put("/route-book/comment/", mockmvc, genComment(routeBookId))
    }

    @Test
    fun testRouteBookTopics(){
        println(get("/route-book/topic-list/", mockmvc, hashMapOf()))
    }

    @Test
    fun testRouteBookList(){
        println(get("/route-book/5a858790c37fe3000c468d19/comment", mockmvc, hashMapOf<String, List<String>>()))
    }

    @Test
    fun testRouteBookListByIds(){
        println(get("/route-book/list", mockmvc, hashMapOf(Pair("route_book_list", listOf("5a90c2c4a94b59dd6486dc12&5a90c31ca94b59e6fc782a0f&5a90c377a94b59ca0c39fba8")))))
    }
}