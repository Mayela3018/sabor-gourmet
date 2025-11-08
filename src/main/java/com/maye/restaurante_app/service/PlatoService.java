package com.maye.restaurante_app.service;

import com.maye.restaurante_app.model.Plato;
import com.maye.restaurante_app.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> listarTodos() {
        return platoRepository.findAll();
    }

    public Plato guardar(Plato plato) {
        return platoRepository.save(plato);
    }

    public Plato obtenerPorId(Long id) {
        return platoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        platoRepository.deleteById(id);
    }
}