package com.example.invoice_generator.repository;

import com.example.invoice_generator.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
