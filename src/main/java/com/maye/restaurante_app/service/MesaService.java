package com.maye.restaurante_app.service;

import com.maye.restaurante_app.model.Mesa;
import com.maye.restaurante_app.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> listarTodas() {
        return mesaRepository.findAll();
    }

    public Mesa guardar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa obtenerPorId(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }

    public void ocuparMesa(Long id) {
        Mesa mesa = obtenerPorId(id);
        if (mesa != null) {
            mesa.setEstado("ocupada");
            mesaRepository.save(mesa);
        }
    }

    public void liberarMesa(Long id) {
        Mesa mesa = obtenerPorId(id);
        if (mesa != null) {
            mesa.setEstado("disponible");
            mesaRepository.save(mesa);
        }
    }
}