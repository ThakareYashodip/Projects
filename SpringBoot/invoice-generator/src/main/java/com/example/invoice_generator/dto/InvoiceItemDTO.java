package com.example.invoice_generator.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItemDTO {
    private Long id;
    private String description;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;
    private Long invoiceId;
}
