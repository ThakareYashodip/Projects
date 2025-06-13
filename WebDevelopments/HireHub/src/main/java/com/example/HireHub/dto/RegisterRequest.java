package com.example.HireHub.dto;

import com.example.HireHub.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private User.Role role;
}
