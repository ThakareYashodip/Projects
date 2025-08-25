package com.example.invoice_generator.controller;

import com.example.invoice_generator.entity.SentEmail;
import com.example.invoice_generator.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody SentEmail email) {
        return emailService.sendSimpleEmail(email);
    }

    @GetMapping("/all-emails")
    public List<SentEmail> getAllEmails(){
        return emailService.getAllEmails();
    }
}
