package com.example.UrbanServe.repository;

import com.example.UrbanServe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // for login
    boolean existsByEmail(String email);      // for checking duplicates
}

