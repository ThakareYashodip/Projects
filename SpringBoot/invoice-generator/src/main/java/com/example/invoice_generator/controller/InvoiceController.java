package com.example.invoice_generator.controller;

import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    // 🟢 Create invoice
    @PostMapping
    public ResponseEntity<Map<String, Object>> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        InvoiceDTO created = invoiceService.createInvoice(invoiceDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Invoice created successfully 🎉");
        response.put("data", created);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 🔵 Get invoice by id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getInvoiceById(@PathVariable Long id) {
        InvoiceDTO invoice = invoiceService.getInvoiceById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Invoice fetched successfully ✅");
        response.put("data", invoice);

        return ResponseEntity.ok(response);
    }

    // 🔵 Get all invoices
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllInvoices() {
        List<InvoiceDTO> invoices = invoiceService.getAllInvoices();

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", invoices.isEmpty() ? "No invoices found ⚠️" : "Invoices fetched successfully ✅");
        response.put("count", invoices.size());
        response.put("data", invoices);

        return ResponseEntity.ok(response);
    }

    // 🟠 Update invoice
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateInvoice(
            @PathVariable Long id,
            @RequestBody InvoiceDTO invoiceDTO
    ) {
        InvoiceDTO updated = invoiceService.updateInvoice(id, invoiceDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Invoice updated successfully ✏️");
        response.put("data", updated);

        return ResponseEntity.ok(response);
    }

    // 🔴 Delete invoice
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Invoice deleted successfully 🗑️");

        return ResponseEntity.ok(response);
    }
}
