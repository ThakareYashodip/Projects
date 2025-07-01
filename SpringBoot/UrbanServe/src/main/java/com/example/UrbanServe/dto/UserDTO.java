package com.example.UrbanServe.dto;

import com.example.UrbanServe.entity.User.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private Role role;
    private String email;
    private String flatNo;
}
