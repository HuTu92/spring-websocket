package com.github.fnpac.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by liuchunlong on 2018/2/23.
 *
 * 配置使用Spring的低层级WebSocket API
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // base
        webSocketHandlerRegistry.addHandler(marcoHandler(), "/marco/v1");
        // supports by sockjs
        webSocketHandlerRegistry.addHandler(marcoHandler(), "/marco/v2").withSockJS();
    }

    @Bean
    public MarcoHandler marcoHandler() {
        return new MarcoHandler();
    }
}
