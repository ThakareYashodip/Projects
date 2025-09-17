package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.InvoiceItemDTO;

import java.util.List;

public interface InvoiceItemService {

    // ➕ Create an item under a specific invoice
    InvoiceItemDTO createItem(Long invoiceId, InvoiceItemDTO dto);

    // 📄 Get all items for a specific invoice
    List<InvoiceItemDTO> getItemsByInvoice(Long invoiceId);

    // 🔄 Update an item by its ID
    InvoiceItemDTO updateItem(Long itemId, InvoiceItemDTO dto);

    // ❌ Delete an item by its ID
    void deleteItem(Long itemId);
}
