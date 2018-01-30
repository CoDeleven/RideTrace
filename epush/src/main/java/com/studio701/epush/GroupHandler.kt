package com.studio701.epush

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession

class GroupHandler:WebSocketHandler {
    override fun handleTransportError(session: WebSocketSession?, exception: Throwable?) {
        println("处理端口错误：" + exception)
    }

    override fun afterConnectionClosed(session: WebSocketSession?, closeStatus: CloseStatus?) {
        println("连接关闭后：" + closeStatus)
    }

    override fun handleMessage(session: WebSocketSession?, message: WebSocketMessage<*>?) {
        println("消息处理：" + message?.payload)
    }

    override fun afterConnectionEstablished(session: WebSocketSession?) {
        println("消息建立后：")
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}