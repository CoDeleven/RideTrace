package com.studio701.epush

import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor
import java.lang.Exception

@Component
class HandshakeInterceptor:HttpSessionHandshakeInterceptor() {
    override fun beforeHandshake(request: ServerHttpRequest?, response: ServerHttpResponse?, wsHandler: WebSocketHandler?, attributes: MutableMap<String, Any>?): Boolean {
        println("beforeHandshake")
        return super.beforeHandshake(request, response, wsHandler, attributes)
    }

    override fun afterHandshake(request: ServerHttpRequest?, response: ServerHttpResponse?, wsHandler: WebSocketHandler?, ex: Exception?) {
        println("afterHandshake")
        super.afterHandshake(request, response, wsHandler, ex)
    }
}