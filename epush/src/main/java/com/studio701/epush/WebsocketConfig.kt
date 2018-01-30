package com.studio701.epush

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver
import org.springframework.messaging.simp.config.ChannelRegistration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.messaging.support.ChannelInterceptorAdapter
import org.springframework.web.socket.config.annotation.*
import org.springframework.web.socket.server.RequestUpgradeStrategy
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean
import org.springframework.web.socket.server.jetty.JettyRequestUpgradeStrategy
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy
import org.springframework.web.socket.server.support.DefaultHandshakeHandler
import java.lang.Exception

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
open class WebsocketConfig:AbstractWebSocketMessageBrokerConfigurer(), WebSocketConfigurer{
    override fun registerStompEndpoints(registry: StompEndpointRegistry?) {
        registry?.addEndpoint("/ridetrace")?.setAllowedOrigins("*")?.withSockJS()
    }


    override fun configureMessageBroker(registry: MessageBrokerRegistry?) {
        super.configureMessageBroker(registry)
        registry?.setApplicationDestinationPrefixes("/app")
        registry?.enableSimpleBroker("/topic")
    }

    @Bean
    open fun createWebSocketContainer(): ServletServerContainerFactoryBean {
        val container = ServletServerContainerFactoryBean()
        container.maxTextMessageBufferSize = 8192
        container.maxBinaryMessageBufferSize =8192
        return container
    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry?) {
        registry?.addHandler(GroupHandler(), "/toGroup")?.setAllowedOrigins("*")
                ?.addInterceptors(HandshakeInterceptor())?.withSockJS()
    }

}