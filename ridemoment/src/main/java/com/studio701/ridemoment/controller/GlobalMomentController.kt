package com.studio701.ridemoment.controller

import com.studio701.ridemoment.entity.ResponseObject
import com.studio701.ridemoment.entity.moment.BaseMoment
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * 动态控制器
 */
@RestController
@RequestMapping(path = ["/moments"])
class GlobalMomentController {

    @Value("\${server.port}") lateinit var serverPort:String;

    /**
     * 获取前几个热门的全局动态
     * @param top 前几个动态
     *
     */
    @RequestMapping(path = ["/overall/hot/{topNum}"], method = [RequestMethod.GET])
    fun getTopHotMoments(@PathVariable("topNum")top:Int):ResponseObject<List<BaseMoment>>{
        // todo 获取前几个热门的全局动态
        return ResponseObject()
    }

    /**
     * 获取前几个最新的全局动态
     */
    @RequestMapping(path = ["/overall/latest/{latestNum}"])
    fun getLatestMoments():ResponseObject<List<BaseMoment>>{
        // todo 获取前几个最新的全局动态
        return ResponseObject()
    }

    @RequestMapping(path = ["/"])
    fun hello():ResponseObject<String>{
        return ResponseObject("准备加载该端口：$serverPort 服务")
    }
}