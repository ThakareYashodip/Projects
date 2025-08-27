package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.PaymentDTO;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.Payment;

public class PaymentMapper {

    // Entity -> DTO
    public static PaymentDTO paymentToDTO(Payment payment){
        return new PaymentDTO(
                payment.getId(),
                payment.getInvoice().getId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getMethod()
        );
    }

    // DTO -> Entity
    public static Payment paymentDtoToEntity(PaymentDTO paymentDTO, Invoice invoice){
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setMethod(paymentDTO.getMethod());
        payment.setInvoice(invoice); // set back-reference
        return payment;
    }
}
