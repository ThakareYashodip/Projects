package com.example.taskFlow.controller;

import com.example.taskFlow.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendMail(@RequestParam String to,
                                           @RequestParam String subject,
                                           @RequestParam String message) {
        emailService.sendSimpleMail(to, subject, message);
        return ResponseEntity.ok("Mail sent successfully!");
    }
}
