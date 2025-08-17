package com.example.invoice_generator.entity;

import com.example.invoice_generator.entity.BaseEntity;
import com.example.invoice_generator.entity.Invoice;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
}
