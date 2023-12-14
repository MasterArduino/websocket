package com.producer.producersocket.controller;



import com.consumer.consumersocket.domain.UserAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.consumer.consumersocket.domain.dto.MessageDto;
import com.consumer.consumersocket.repos.UserAuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private  UserAuditRepository userAuditRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    // Добавлен конструктор с внедрением зависимости
    @Autowired
    public ProducerController(UserAuditRepository userAuditRepository) {
        this.userAuditRepository = userAuditRepository;
    }
    @PostMapping("/send-message/{userId}")
    public ResponseEntity<String> sendMessageToUser(@PathVariable String userId) {
        logger.info("Sending message to user: {}", userId);

        // Проверяем существование пользователя
        Optional<UserAudit> existingUser = userAuditRepository.findByUserId(userId);
        UserAudit userAudit = existingUser.orElseGet(() -> {
            UserAudit newUser = new UserAudit();
            newUser.setUserId(userId);
            return newUser;
        });

        MessageDto messageDto = new MessageDto(true, "gold", 123, "Hello World", userId);
        messagingTemplate.convertAndSendToUser(userId, "/topic/messages", messageDto);
        return ResponseEntity.ok("Message sent to user: " + userId);
    }
}