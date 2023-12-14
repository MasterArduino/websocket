package com.consumer.consumersocket.controller;

import com.consumer.consumersocket.domain.UserAudit;
import com.consumer.consumersocket.domain.dto.MessageDto;
import com.consumer.consumersocket.repos.UserAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    @Autowired
    private UserAuditRepository userAuditRepository;

    @MessageMapping("/messages")
    @SendToUser("/topic/messages")
    public void processMessageFromProducer(@Payload MessageDto messageDto, Principal principal) {
        UserAudit userAudit = new UserAudit();
        userAudit.setUserId(messageDto.getUserId()); // Извлекаем userId из сообщения
        userAudit.setIsActive(messageDto.isActive());
        userAudit.setColor(messageDto.getColor());
        userAudit.setNumber(messageDto.getNumber());
        userAudit.setMessage(messageDto.getMessage());
        userAuditRepository.save(userAudit);
    }

    @GetMapping("/user-audit")
    public String getUserAudit(Principal principal, Model model) {
        Optional<UserAudit> userAuditOptional = userAuditRepository.findByUserId(principal.getName());

        if (userAuditOptional.isPresent()) {
            UserAudit userAudit = userAuditOptional.get();
            model.addAttribute("userAuditList", Collections.singletonList(userAudit));
        } else {
            model.addAttribute("userAuditList", Collections.emptyList());
        }

        return "user-audit";
    }
}