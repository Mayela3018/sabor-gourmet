package com.maye.restaurante_app.repository;

import com.maye.restaurante_app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}