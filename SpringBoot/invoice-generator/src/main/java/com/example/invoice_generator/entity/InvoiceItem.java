package com.example.invoice_generator.entity;

import com.example.invoice_generator.entity.BaseEntity;
import com.example.invoice_generator.entity.Invoice;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItem extends BaseEntity {

    @NotBlank
    @Size(min = 3, max = 100 , message = "Description should be upto 100 words.")
    private String description;
    private Integer quantity;
    private Double unitPrice;
    private Double lineTotal;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
