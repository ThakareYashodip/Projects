package com.example.UrbanServe.dto;

import com.example.UrbanServe.entity.User.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    private String name;
    private String email;
    private String password;
    private Role role;        // or default as RESIDENT
    private String flatNumber;
}
