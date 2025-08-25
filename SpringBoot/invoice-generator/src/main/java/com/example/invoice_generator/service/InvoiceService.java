package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.entity.Client;

import java.util.List;

public interface InvoiceService {
    InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);
    InvoiceDTO getInvoiceById(Long id);
    List<InvoiceDTO> getAllInvoices();
    InvoiceDTO updateInvoice(Long id , InvoiceDTO invoiceDTO);
    void deleteInvoice(Long id);
}
