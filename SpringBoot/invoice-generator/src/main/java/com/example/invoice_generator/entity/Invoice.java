package com.example.invoice_generator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Invoice extends BaseEntity {

    private String invoiceNumber;
    private LocalDate date;
    private LocalDate dueDate;
    private String status; // e.g., DRAFT, SENT, PAID
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceItem> items;
}
