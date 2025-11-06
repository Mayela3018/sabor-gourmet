package com.maye.restaurante_app.repository;

import com.maye.restaurante_app.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}