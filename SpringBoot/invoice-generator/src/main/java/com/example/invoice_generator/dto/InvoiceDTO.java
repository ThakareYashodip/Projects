package com.example.invoice_generator.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Data
public class InvoiceDTO {
    private Long id ;
    private String invoicenumber;
    private LocalDate invoiceDate;
    private Long clientId;
    private List<InvoiceItemDTO> items;
    private double total;
}
