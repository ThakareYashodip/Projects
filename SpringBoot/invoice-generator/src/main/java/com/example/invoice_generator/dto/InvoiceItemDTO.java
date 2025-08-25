package com.example.invoice_generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
public class InvoiceItemDTO {
    private Long id;
    private String description;
    private int quantity;
    private double price;

}
