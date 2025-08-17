package com.example.invoice_generator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users") // avoid conflict with SQL reserved keyword
public class User extends BaseEntity {

    private String username;
    private String password;
    private String role; // e.g., ADMIN, USER
}
