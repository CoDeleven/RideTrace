package com.studio701.epush

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @MessageMapping("/group/{groupId}")
    fun handleMessageForGroup(@DestinationVariable("groupId") groupId:String, headAccessor:SimpMessageHeaderAccessor){
        println("收到消息" + groupId)
    }
}