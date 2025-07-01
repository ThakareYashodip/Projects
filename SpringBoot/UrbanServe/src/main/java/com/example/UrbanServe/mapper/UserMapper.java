package com.example.UrbanServe.mapper;

import com.example.UrbanServe.dto.RegisterRequestDTO;
import com.example.UrbanServe.dto.UserDTO;
import com.example.UrbanServe.entity.User;

public class UserMapper {

    public static User fromRegisterRequest(RegisterRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole() != null ? dto.getRole() : User.Role.RESIDENT); // Default fallback
        user.setFlatNumber(dto.getFlatNumber());
        return user;
    }

    // Entity → DTO
    public static UserDTO userEntityToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getRole(),
                user.getEmail(),
                user.getFlatNumber()
        );
    }
}
