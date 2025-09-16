package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.dto.InvoiceItemDTO;

import java.util.List;

public interface InvoiceItemService {
    InvoiceItemDTO addInvoiceItem(Long invoiceId,InvoiceItemDTO invoiceItemDTO);
    InvoiceItemDTO getInvoiceItemById(Long id);
    List<InvoiceItemDTO> getAllItems();
    InvoiceItemDTO updateInvoiceById(Long id, InvoiceItemDTO invoiceItemDTO);
    void deleteItemById(Long id);
}
