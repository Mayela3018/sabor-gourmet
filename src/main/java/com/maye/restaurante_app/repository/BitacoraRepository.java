package com.maye.restaurante_app.repository;

import com.maye.restaurante_app.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {
}