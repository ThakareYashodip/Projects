package com.example.invoice_generator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends BaseEntity {

    private Double amount;
    private LocalDate paymentDate;
    private String method; // e.g., CASH, CARD, UPI

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
