package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO createPayment(Long invoiceId, PaymentDTO dto);
    List<PaymentDTO> getPaymentsByInvoice(Long invoiceId);
    List<PaymentDTO> getPaymentsByClient(Long clientId);
    PaymentDTO updatePayment(Long id, PaymentDTO dto);
    void deletePayment(Long id);
}
