package com.example.invoice_generator.mapper;

import com.example.invoice_generator.dto.UserDTO;
import com.example.invoice_generator.dto.UserRegisterDTO;
import com.example.invoice_generator.entity.User;

public class UserMapper {

    // Convert Entity → DTO
    public static UserDTO userToDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    // Convert DTO → Entity (without password, used for safe responses)
    public static User userDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        return user;
    }

    // Convert RegisterDTO → Entity (with password, used at signup)
    public static User userRegisterDtoToEntity(UserRegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword()); // ⚠️ should be encoded before saving
        user.setRole(registerDTO.getRole());
        return user;
    }

    // Convert Entity → RegisterDTO (for responses, but password is excluded for safety)
    public static UserRegisterDTO userToRegisterDto(User user) {
        return new UserRegisterDTO(
                user.getUsername(),
                user.getEmail(),
                null,               // ❌ Do not expose password
                user.getRole()
        );
    }
}
