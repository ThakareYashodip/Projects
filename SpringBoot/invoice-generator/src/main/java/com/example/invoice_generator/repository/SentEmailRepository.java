package com.example.invoice_generator.repository;

import com.example.invoice_generator.entity.SentEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentEmailRepository extends JpaRepository<SentEmail, Long> {
}
