package com.example.invoice_generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegisterDTO {
    private String username;
    private String email;
    private String password;
    private String role; // e.g., ADMIN, USER
}
