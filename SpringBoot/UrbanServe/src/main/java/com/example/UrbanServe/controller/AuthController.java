package com.example.UrbanServe.controller;

import com.example.UrbanServe.dto.LoginRequestDTO;
import com.example.UrbanServe.dto.RegisterRequestDTO;
import com.example.UrbanServe.dto.UserDTO;
import com.example.UrbanServe.entity.User;
import com.example.UrbanServe.mapper.UserMapper;
import com.example.UrbanServe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterRequestDTO dto){
        User newUser = userService.registerUser(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserMapper.userEntityToDTO(newUser));
    }


    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginRequestDTO dto){
        User user = userService.authenticateUser(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok(UserMapper.userEntityToDTO(user));
    }

}
