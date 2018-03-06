package com.studio701.routebook.controller

import com.studio701.entity.common.ResponseObject
import com.studio701.entity.routebook.Comment
import com.studio701.entity.routebook.RouteBook
import com.studio701.routebook.service.interfaces.IRouteBookService
import com.studio701.routebook.service.interfaces.IRouteOperatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.netflix.zuul.filters.Route
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/route-book")
class RouteBookController {
    @Autowired
    lateinit var routeBookService: IRouteBookService

    @Autowired
    lateinit var routeBookOperator: IRouteOperatorService

    @RequestMapping("/detail/{bookId}", method = [RequestMethod.GET])
    fun queryDetailRouteBook(@PathVariable("bookId") bookId:String):ResponseObject<RouteBook>{
        return ResponseObject(routeBookService.queryDetailBook(routeBookId = bookId))
    }

    @RequestMapping("/", method = [RequestMethod.POST])
    fun createRouteBook(@RequestBody routeBook: RouteBook): ResponseObject<String> {
        routeBookService.createRouteBook(routeBook)
        return ResponseObject()
    }

    @RequestMapping("/{routeBookId}", method = [RequestMethod.DELETE])
    fun deleteRouteBook(@PathVariable("routeBookId") routeBookId: String): ResponseObject<String> {
        return ResponseObject("不支持删除...请联系管理员", 404)
    }

    @RequestMapping("/{userId}", method = [RequestMethod.GET])
    fun queryUserRouteBooks(@PathVariable("userId") userId: String, @RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<RouteBook>> {
        return ResponseObject(routeBookService.listRouteBooks(userId, skip, num))
    }

    @RequestMapping("/all", method = [RequestMethod.GET])
    fun queryAllRouteBooks(@RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<RouteBook>> {
        return ResponseObject(routeBookService.listRouteBooks("", skip, num))
    }

    @RequestMapping("/list", method = [RequestMethod.GET])
    fun queryListRouteBooks(@RequestParam("route_book_list") routeBookIdList:String):ResponseObject<List<RouteBook>>{
        val list = routeBookIdList.split("""&""")
        return ResponseObject(routeBookService.listRouteBooks(list))
    }

    @RequestMapping("/", method = [RequestMethod.GET])
    fun queryRouteBooksByTopic(@RequestParam("topic") topic: String): ResponseObject<List<RouteBook>> {
        return ResponseObject(routeBookService.listTopicBooks(topic))
    }

    @RequestMapping("/good/{userId}/{routeBookId}", method = [RequestMethod.PUT])
    fun good4RouteBook(@PathVariable("userId") userId: String, @PathVariable("routeBookId") routeBookId: String): ResponseObject<String> {
        routeBookOperator.good(userId, routeBookId)
        return ResponseObject()
    }

    @RequestMapping("/comment", method = [RequestMethod.PUT])
    fun comment4RouteBook(@RequestBody comment: Comment): ResponseObject<String> {
        routeBookOperator.comment(comment)
        return ResponseObject()
    }

    @RequestMapping("/{routeBookId}/comment", method = [RequestMethod.GET])
    fun listComments(@PathVariable("routeBookId") routeBookId: String): ResponseObject<List<Comment>> {
        return ResponseObject(routeBookOperator.listComments(routeBookId))
    }

    @RequestMapping("/collect/{userId}/{routeBookId}", method = [RequestMethod.PUT])
    fun collect4RouteBook(@PathVariable("userId") userId: String, @PathVariable("routeBookId") routeBookId: String): ResponseObject<String> {
        routeBookOperator.collect(userId, routeBookId)
        return ResponseObject()
    }


    @RequestMapping("/topic-list", method = [RequestMethod.GET])
    fun listAllTopic(): ResponseObject<List<String>> {
        return ResponseObject(routeBookService.listAllTopic())
    }

    @RequestMapping("{userId}/collect/list", method = [RequestMethod.GET])
    fun getUserCollectRouteBook(@PathVariable("userId") userId: String):ResponseObject<List<RouteBook>?>{
        return ResponseObject(routeBookService.listMyRouteBook(userId))
    }


}