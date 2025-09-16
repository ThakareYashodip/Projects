package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO createPayment(Long invoiceId, PaymentDTO paymentDTO);
    PaymentDTO getPaymentById(Long id);
    List<PaymentDTO> getPaymentsByInvoice(Long invoiceId);
    List<PaymentDTO> getAllPayments();
    void deletePayment(Long id);
}
