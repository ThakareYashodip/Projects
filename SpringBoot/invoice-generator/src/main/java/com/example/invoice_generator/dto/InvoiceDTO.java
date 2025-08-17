package com.example.invoice_generator.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InvoiceDTO {
    private Long id ;
    private String invoicenumber;
    private LocalDate invoiceDate;
    private Long clientId;
    private List<InvoiceDTO> items;
    private double total;
}
