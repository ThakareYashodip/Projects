package com.example.invoice_generator.service;

import com.example.invoice_generator.entity.SentEmail;

import java.util.List;

public interface EmailService {
    String sendSimpleEmail(SentEmail email);
    List<SentEmail> getAllEmails();
}
