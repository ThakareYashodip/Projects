package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.PaymentDTO;
import com.example.invoice_generator.entity.Client;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.Payment;
import com.example.invoice_generator.mapper.PaymentMapper;
import com.example.invoice_generator.repository.ClientRepository;
import com.example.invoice_generator.repository.InvoiceRepository;
import com.example.invoice_generator.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;

    @Override
    public PaymentDTO createPayment(Long invoiceId, PaymentDTO dto) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        Client client = invoice.getClient(); // auto-linked via invoice

        Payment payment = PaymentMapper.toEntity(dto, invoice, client);
        return PaymentMapper.toDTO(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentDTO> getPaymentsByInvoice(Long invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId)
                .stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PaymentDTO> getPaymentsByClient(Long clientId) {
        return paymentRepository.findByClientId(clientId)
                .stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePayment(Long id, PaymentDTO dto) {
        Payment existing = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        existing.setAmount(dto.getAmount());
        existing.setMethod(dto.getMethod());
        existing.setPaymentDate(LocalDate.parse(dto.getPaymentDate()));

        return PaymentMapper.toDTO(paymentRepository.save(existing));
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
