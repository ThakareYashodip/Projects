package com.example.invoice_generator.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentDTO {
    private Long id ;
    private Long invoiceId;
    private double amount;
    private LocalDate paymentDate;
}
