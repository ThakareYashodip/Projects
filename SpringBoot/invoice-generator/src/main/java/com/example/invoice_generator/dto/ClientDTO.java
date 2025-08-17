package com.example.invoice_generator.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
}
