package com.example.invoice_generator.service;

import com.example.invoice_generator.entity.SentEmail;
import com.example.invoice_generator.repository.SentEmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SentEmailRepository sentEmailRepository;

    @Override
    public String sendSimpleEmail(SentEmail email) {
        email.setSentAt(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("ganuthakare99@gmail.com"); // configure in application.properties
            message.setTo(email.getRecipient());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            javaMailSender.send(message);

            email.setSuccess(true);
            sentEmailRepository.save(email);
            log.info("Incoming email request: recipient={}, subject={}, body={}",
                    email.getRecipient(), email.getSubject(), email.getBody());

            log.info("✅ Email sent successfully to {}", email.getRecipient());
            return "🟢 Success!";
        } catch (Exception e) {
            email.setSuccess(false);
            sentEmailRepository.save(email);

            log.error("❌ Failed to send email to {}: {}", email.getRecipient(), e.getMessage());
            return "🔴 Failed!";
        }
    }


    @Override
    public List<SentEmail> getAllEmails() {
        return sentEmailRepository.findAll();
    }
}
