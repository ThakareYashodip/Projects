package com.example.invoice_generator.entity;

import com.example.invoice_generator.entity.BaseEntity;
import com.example.invoice_generator.entity.Invoice;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client extends BaseEntity {

    @NotBlank
    @Size(min = 3,max = 30 , message = "Client name must required !")
    private String name;

    @Email
    private String email;

    @Size(min = 10,max = 10,message = "Phone number must be 10 digit . ")
    private String phone;

    @NotBlank
    @Size(min = 3, max = 100, message = "Address must be between 3 to 100 characters . ")
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
}
