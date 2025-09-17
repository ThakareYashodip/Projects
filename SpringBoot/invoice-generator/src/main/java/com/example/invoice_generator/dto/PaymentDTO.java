package com.example.invoice_generator.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    @NotNull(message = "Payment method is required")
    private String method;

    private Long invoiceId;
    private Long clientId;

    // ✅ No need for user to pass this, it will be auto-generated
    private String paymentDate;
    private String createdAt;    // from BaseEntity
}
