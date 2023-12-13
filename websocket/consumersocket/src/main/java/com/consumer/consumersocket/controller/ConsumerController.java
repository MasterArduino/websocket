package com.consumer.consumersocket.controller;

import com.consumer.consumersocket.domain.UserAudit;
import com.consumer.consumersocket.domain.dto.MessageDto;
import com.consumer.consumersocket.repos.UserAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    @Autowired
    private UserAuditRepository userAuditRepository;

    @MessageMapping("/messages")
    @SendToUser("/topic/messages")
    public void processMessageFromProducer(@Payload MessageDto messageDto, Principal principal) {
        UserAudit userAudit = new UserAudit();
        userAudit.setUserId(principal.getName());
        userAudit.setIsActive(messageDto.isActive());
        userAudit.setColor(messageDto.getColor());
        userAudit.setNumber(messageDto.getNumber());
        userAudit.setMessage(messageDto.getMessage());
        userAuditRepository.save(userAudit);
    }

    @GetMapping("/user-audit")
    public List<UserAudit> getUserAudit(Principal principal) {
        return userAuditRepository.findByUserId(principal.getName());
    }
}
