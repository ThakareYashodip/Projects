package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.UserDTO;
import com.example.invoice_generator.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserRegisterDTO userRegisterDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id,UserRegisterDTO userRegisterDTO);
    void deleteUser(Long id);
}
