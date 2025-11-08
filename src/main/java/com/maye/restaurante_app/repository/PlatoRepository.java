package com.maye.restaurante_app.repository;

import com.maye.restaurante_app.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
}