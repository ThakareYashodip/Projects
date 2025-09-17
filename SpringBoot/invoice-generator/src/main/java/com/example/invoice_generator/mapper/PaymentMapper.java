package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.PaymentDTO;
import com.example.invoice_generator.entity.Client;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.Payment;

import java.time.LocalDate;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .method(payment.getMethod())
                .paymentDate(String.valueOf(payment.getPaymentDate()))
                .invoiceId(payment.getInvoice().getId())
                .clientId(payment.getClient().getId())
                .createdAt(payment.getCreatedAt().toString())
                .build();
    }

    // DTO -> Entity
    public static Payment toEntity(PaymentDTO paymentDTO, Invoice invoice, Client client){
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(LocalDate.parse(paymentDTO.getPaymentDate()));
        payment.setMethod(paymentDTO.getMethod());
        payment.setInvoice(invoice); // set back-reference
        payment.setClient(client);
        return payment;
    }
}


