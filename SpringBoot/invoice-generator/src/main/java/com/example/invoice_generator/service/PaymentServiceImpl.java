package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.PaymentDTO;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.Payment;
import com.example.invoice_generator.mapper.PaymentMapper;
import com.example.invoice_generator.repository.InvoiceRepository;
import com.example.invoice_generator.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public PaymentDTO createPayment(Long invoiceId, PaymentDTO dto) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        if (dto.getPaymentDate() == null) {
            dto.setPaymentDate(LocalDate.from(LocalDateTime.now()));
        }

        Payment payment = PaymentMapper.toEntity(dto, invoice);
        return PaymentMapper.toDTO(paymentRepository.save(payment));
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<PaymentDTO> getPaymentsByInvoice(Long invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId)
                .stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
