package com.producer.producersocket.controller;



import com.consumer.consumersocket.domain.UserAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.consumer.consumersocket.domain.dto.MessageDto;
import com.consumer.consumersocket.repos.UserAuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private UserAuditRepository userAuditRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);


    @Autowired
    public ProducerController(UserAuditRepository userAuditRepository) {
        this.userAuditRepository = userAuditRepository;
    }

    @GetMapping("/send-message")
    public ResponseEntity<String> sendMessageToUser() {
        logger.info("Sending message to all users");

                UserAudit newUser = new UserAudit();

        MessageDto messageDto = new MessageDto(true, "gold", 123, "Hello World", newUser.getUserId());

        messagingTemplate.convertAndSend("/topic/messages", messageDto);

        return ResponseEntity.ok("Message sent to all users");
    }


}