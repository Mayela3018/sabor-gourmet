package com.maye.restaurante_app.repository;

import com.maye.restaurante_app.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {
}