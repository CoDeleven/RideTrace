package com.studio701.ridemoment.controller

import com.studio701.entity.common.ResponseObject
import com.studio701.ridemoment.service.LiveService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.xml.ws.Response

@RestController
@RequestMapping("/live")
class LiveController {
    @Autowired
    lateinit var service:LiveService

    @RequestMapping("/getRtmp")
    fun getLiveRtmpUrl():ResponseObject<String>{
        return ResponseObject(service.deliverURL)
    }

    @RequestMapping("/getLive")
    fun getLiveUrl():ResponseObject<String>{
        return ResponseObject(service.receiveURL)
    }
}