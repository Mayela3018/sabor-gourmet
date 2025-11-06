package com.maye.restaurante_app.service;

import com.maye.restaurante_app.model.Bitacora;
import com.maye.restaurante_app.repository.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitacoraService {

    @Autowired
    private BitacoraRepository bitacoraRepository;

    public void guardar(String accion, String entidad) {
        Bitacora b = new Bitacora();
        b.setAccion(accion);
        b.setEntidad(entidad);
        b.setFechaHora(LocalDateTime.now());
        bitacoraRepository.save(b);
    }

    public List<Bitacora> listarTodas() {
        return bitacoraRepository.findAll();
    }
}