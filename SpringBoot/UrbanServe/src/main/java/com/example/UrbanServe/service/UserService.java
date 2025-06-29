package com.example.UrbanServe.service;

import com.example.UrbanServe.dto.RegisterRequestDTO;
import com.example.UrbanServe.entity.User;
import com.example.UrbanServe.mapper.UserMapper;
import com.example.UrbanServe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
//    User registerUser(RegisterRequestDTO dto);
    User registerUser(RegisterRequestDTO dto){
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        User user = UserMapper.fromRegisterRequest(dto);
        return userRepository.save(user);
    }
//    User authenticateUser(String email, String password); // or return a token
    User authenticateUser(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty() || !optionalUser.get().getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return optionalUser.get();
    }
//    User getUserById(Long id);
    User getUserById(long id){
        return userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found !")
        );
    }
//    boolean emailExists(String email);
    public boolean emailExists(String email){
        return userRepository.existsByEmail(email);
    }
}
