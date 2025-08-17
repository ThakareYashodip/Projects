package com.example.invoice_generator.repository;

import com.example.invoice_generator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
