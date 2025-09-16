package com.example.invoice_generator.controller;

import com.example.invoice_generator.config.ApiResponse;
import com.example.invoice_generator.dto.UserDTO;
import com.example.invoice_generator.dto.UserRegisterDTO;
import com.example.invoice_generator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 🟢 Register a new user
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDTO>> registerUser(@RequestBody UserRegisterDTO registerDTO) {
        UserDTO createdUser = userService.createUser(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<UserDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CREATED.value())
                        .message("User registered successfully 🎉")
                        .data(createdUser)
                        .build()
        );
    }

    // 🟢 Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(
                ApiResponse.<UserDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("User fetched successfully ✅")
                        .data(user)
                        .build()
        );
    }

    // 🟢 Get all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(
                ApiResponse.<List<UserDTO>>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message(users.isEmpty() ? "No users found ⚠️" : "Users fetched successfully ✅")
                        .data(users)
                        .build()
        );
    }

    // 🟠 Update user
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Long id , @RequestBody UserRegisterDTO userRegisterDTO){
        UserDTO updatedUser = userService.updateUser(id,userRegisterDTO);
        return ResponseEntity.ok(
                ApiResponse.<UserDTO>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("User updated successfully ✏️")
                        .data(updatedUser)
                        .build()
        );
    }

    // 🔴 Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.OK.value())
                        .message("User deleted successfully 🗑️")
                        .data(null)
                        .build()
        );
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "🚀 Invoice Generator API is working!";
    }
}
