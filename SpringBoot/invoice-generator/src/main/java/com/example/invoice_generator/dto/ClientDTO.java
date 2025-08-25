package com.example.invoice_generator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 3,max = 30 ,message = "Client name must required !")
    private String name;

    @Email
    private String email;

    @NotBlank
    @Size(min = 3,max = 100,message = "Address should be upto 100 characters .")
    private String address;

    private String phone;
}
