package com.github.fnpac.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.logging.Logger;

/**
 * Created by liuchunlong on 2018/2/23.
 */
public class MarcoHandler extends AbstractWebSocketHandler {

    private static final Logger logger = Logger.getLogger(MarcoHandler.class.getName());

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        logger.info("Received message: " + message.getPayload());

        Thread.sleep(2000);

        session.sendMessage(new TextMessage("Polo!"));
    }
}
