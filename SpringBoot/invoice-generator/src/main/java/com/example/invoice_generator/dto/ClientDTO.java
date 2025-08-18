package com.example.invoice_generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
}
