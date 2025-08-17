package com.example.invoice_generator.entity;

import com.example.invoice_generator.entity.BaseEntity;
import com.example.invoice_generator.entity.Invoice;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItem extends BaseEntity {

    private String description;
    private Integer quantity;
    private Double unitPrice;
    private Double lineTotal;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
