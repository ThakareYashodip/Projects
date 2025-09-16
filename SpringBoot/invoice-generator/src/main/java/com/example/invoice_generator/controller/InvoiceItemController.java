package com.example.invoice_generator.controller;

import com.example.invoice_generator.config.ApiResponse;
import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.service.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/invoice-item")
@RequiredArgsConstructor
public class InvoiceItemController {

    private final InvoiceItemService invoiceItemService;

    // Create a new Invoice Item linked to an Invoice by invoiceId
    @PostMapping("/{invoiceId}")
    public ResponseEntity<ApiResponse<InvoiceItemDTO>> createInvoiceItem(
            @PathVariable Long invoiceId,
            @RequestBody InvoiceItemDTO invoiceItemDTO) {

        InvoiceItemDTO createdItem = invoiceItemService.addInvoiceItem(invoiceId, invoiceItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<InvoiceItemDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CREATED.value())
                        .message("Invoice Item added Successfully 😁")
                        .data(createdItem)
                        .build()
        );
    }

    // Get all invoice items
    @GetMapping
    public ResponseEntity<ApiResponse<List<InvoiceItemDTO>>> getAllInvoiceItems() {
        List<InvoiceItemDTO> items = invoiceItemService.getAllItems();
        return ResponseEntity.ok(
                ApiResponse.<List<InvoiceItemDTO>>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Invoice Items fetched Successfully 😀")
                        .data(items)
                        .build()
        );
    }

    // Get an invoice item by its own ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InvoiceItemDTO>> getInvoiceItemById(@PathVariable Long id) {
        InvoiceItemDTO item = invoiceItemService.getInvoiceItemById(id);
        return ResponseEntity.ok(
                ApiResponse.<InvoiceItemDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Invoice Item fetched Successfully 😁")
                        .data(item)
                        .build()
        );
    }

    // Update invoice item by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InvoiceItemDTO>> updateInvoiceItemById(
            @PathVariable Long id,
            @RequestBody InvoiceItemDTO invoiceItemDTO) {

        InvoiceItemDTO updatedItem = invoiceItemService.updateInvoiceById(id, invoiceItemDTO);
        return ResponseEntity.ok(
                ApiResponse.<InvoiceItemDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Invoice Item updated Successfully 😁")
                        .data(updatedItem)
                        .build()
        );
    }

    // Delete invoice item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteInvoiceItemById(@PathVariable Long id) {
        invoiceItemService.deleteItemById(id);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("Invoice Item deleted Successfully!")
                        .data(null)
                        .build()
        );
    }
}
