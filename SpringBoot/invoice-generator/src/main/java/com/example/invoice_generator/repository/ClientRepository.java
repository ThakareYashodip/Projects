package com.example.invoice_generator.repository;

import com.example.invoice_generator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
