package com.producer.producersocket.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyTextWebSocketHandler extends TextWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyTextWebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Получаем текстовое сообщение от клиента
        String clientMessage = message.getPayload();

        // Логирование для проверки вызова обработчика
        logger.info("Handling text message: {}", clientMessage);

        // Обработка сообщения (в данном случае, отправка обратно клиенту)
        session.sendMessage(new TextMessage("Server received: " + clientMessage));
    }
}
