package com.example.invoice_generator.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SentEmail extends BaseEntity {

    private String recipient;
    private String subject;

    @Column(length = 5000) // large body
    private String body;

    @CreatedDate
    private LocalDateTime sentAt;

    private boolean success;
}
