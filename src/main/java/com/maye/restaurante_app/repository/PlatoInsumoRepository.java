package com.maye.restaurante_app.repository;

import com.maye.restaurante_app.model.PlatoInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoInsumoRepository extends JpaRepository<PlatoInsumo, Long> {
}