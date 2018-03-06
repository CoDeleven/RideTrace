package com.studio701.epush

import com.studio701.entity.common.Point
import com.studio701.entity.epush.MessageType
import com.studio701.entity.epush.TopicMessage
import com.studio701.utils.JsonUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.logging.logback.LogbackLoggingSystem
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@org.springframework.stereotype.Controller
class Controller {
    private val logger = LoggerFactory.getLogger(Controller.javaClass)
    @Autowired
    private val template: SimpMessagingTemplate? = null

    companion object {
        // 保存位置信息的集合，外层Map的Key是小组ID，内层Map的Key是该小组成员的UserId，Point是位置信息
        private val location = mutableMapOf<String, MutableMap<String, Point>>()
        // 外层Map的Key是小组ID，内层Map的Key是该小组成员的UserID，内层Map的Value是对应成员的图灵ID
        private val tourling = mutableMapOf<String, MutableMap<String, String>>()

    }

    @RequestMapping("/{type}/clear/{groupId}", method = [RequestMethod.GET, RequestMethod.DELETE])
    fun clearGroupIdInfo(@PathVariable("type") type:String, @PathVariable("groupId") groupId: String){
        if("TOURLING" == type){
            tourling[groupId]?.clear()
        }else if("LOCATION" == type){
            location[groupId]?.clear()
        }
    }

    @MessageMapping("/{groupId}")
    fun handleMessageForGroup(@DestinationVariable("groupId") groupId: String, headAccessor: SimpMessageHeaderAccessor, @Payload content: String?) {
        logger.info("收到信息：" + content)
        var result:String? = ""
        try{
            val message = JsonUtils.convertString2Object(content, TopicMessage::class.java)
            result = when(message.messageType){
                MessageType.LOCATION -> handleLocationMessage(message)
                MessageType.PARTICIPATE -> handleParticipateMessage(message)
                else -> content
            }
        }catch (e:Exception){

        }

        logger.info("转发消息：" + result)
        template?.convertAndSend("/topic/$groupId", result)
    }

    private fun handleParticipateMessage(topicMessage: TopicMessage):String{
        if(tourling[topicMessage.groupId] == null){
            tourling[topicMessage.groupId] = hashMapOf()
        }
        val tourlingId = topicMessage.param!!["tourling-data"] as String
        tourling[topicMessage.groupId]!![topicMessage.from] = tourlingId

        topicMessage.param["tourling-data-list"] = tourling[topicMessage.groupId]
        return JsonUtils.convertObject2String(topicMessage)
    }

    private fun handleLocationMessage(topicMessage: TopicMessage):String{
        // 检测该grouId下是否存在LocationMap
        if(location[topicMessage.groupId] == null){
            location[topicMessage.groupId] = hashMapOf()
        }
        // 获取message的参数，并根据key获取信息
        val point = getMessageParamData(topicMessage.param, "location-data", Point::class.java)
        // 将收到的位置参数保存到location里
        location[topicMessage.groupId]!![topicMessage.from] = point
        // 将location对应群组的位置信息保存到param里，转发
        topicMessage.param["location-data-list"] = location[topicMessage.groupId]

        return JsonUtils.convertObject2String(topicMessage)
    }

    private  fun <T> getMessageParamData(param:MutableMap<String, in T>?, key:String, clazz:Class<T>):T{
        val data = param?.get(key)

        return JsonUtils.convertAny2Another(data, clazz)
    }
}