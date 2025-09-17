package com.example.invoice_generator.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users") // avoid conflict with SQL reserved keyword
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {

    @Email
    private String email;

    @NotNull
    @Size(min = 3 , max = 30 , message = "Username is required !")
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private String role; // e.g., ADMIN, USER
}
