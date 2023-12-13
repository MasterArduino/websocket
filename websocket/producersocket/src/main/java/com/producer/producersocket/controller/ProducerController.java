package com.producer.producersocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.consumer.consumersocket.domain.dto.MessageDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);


    @PostMapping("/send-message/{userId}")
    public ResponseEntity<String> sendMessageToUser(@PathVariable String userId) {
        logger.info("Sending message to user: {}", userId);
        MessageDto messageDto = new MessageDto(true, "gold", 123, "Hello World");
        messagingTemplate.convertAndSendToUser(userId, "/topic/messages", messageDto);
        return ResponseEntity.ok("Message sent to user: " + userId);
    }
}