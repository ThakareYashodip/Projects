package com.example.invoice_generator.controller;

import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.service.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices/{invoiceId}/items")
public class InvoiceItemController {

    private final InvoiceItemService invoiceItemService;

    // ➕ Create item
    @PostMapping
    public ResponseEntity<InvoiceItemDTO> createItem(
            @PathVariable Long invoiceId,
            @RequestBody InvoiceItemDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(invoiceItemService.createItem(invoiceId, dto));
    }

    // 📄 Get all items of an invoice
    @GetMapping
    public ResponseEntity<List<InvoiceItemDTO>> getItems(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(invoiceItemService.getItemsByInvoice(invoiceId));
    }

    // 🔄 Update item
    @PutMapping("/{itemId}")
    public ResponseEntity<InvoiceItemDTO> updateItem(
            @PathVariable Long invoiceId,
            @PathVariable Long itemId,
            @RequestBody InvoiceItemDTO dto) {
        return ResponseEntity.ok(invoiceItemService.updateItem(itemId, dto));
    }

    // ❌ Delete item
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(
            @PathVariable Long invoiceId,
            @PathVariable Long itemId) {
        invoiceItemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
