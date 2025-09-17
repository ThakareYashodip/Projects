package com.example.invoice_generator.controller;

import com.example.invoice_generator.dto.PaymentDTO;
import com.example.invoice_generator.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
    public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{invoiceId}")
    public ResponseEntity<PaymentDTO> createPayment(
            @PathVariable Long invoiceId,
            @RequestBody PaymentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.createPayment(invoiceId, dto));
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByInvoice(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(paymentService.getPaymentsByInvoice(invoiceId));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(paymentService.getPaymentsByClient(clientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(
            @PathVariable Long id,
            @RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.updatePayment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
