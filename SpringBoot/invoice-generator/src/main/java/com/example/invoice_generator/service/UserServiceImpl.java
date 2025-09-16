package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.UserDTO;
import com.example.invoice_generator.dto.UserRegisterDTO;
import com.example.invoice_generator.entity.User;
import com.example.invoice_generator.mapper.UserMapper;
import com.example.invoice_generator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserRegisterDTO userRegisterDTO) {
        User user = UserMapper.userRegisterDtoToEntity(userRegisterDTO);

        // encode password before saving
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        return UserMapper.userToDto(userRepository.save(user));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository
                .findById(id)
                .map(UserMapper::userToDto)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserRegisterDTO userRegisterDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Update fields
        existingUser.setUsername(userRegisterDTO.getUsername());
        existingUser.setEmail(userRegisterDTO.getEmail());

        // encode password if provided
        if (userRegisterDTO.getPassword() != null && !userRegisterDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        }

        existingUser.setRole(userRegisterDTO.getRole());

        return UserMapper.userToDto(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found!");
        }
        userRepository.deleteById(id);
    }
}
