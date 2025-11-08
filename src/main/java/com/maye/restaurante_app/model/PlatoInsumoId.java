package com.maye.restaurante_app.model;

import java.io.Serializable;
import java.util.Objects;

public class PlatoInsumoId implements Serializable {
    private Long plato;
    private Long insumo;

    // Getters, setters, equals, hashCode
    public Long getPlato() { return plato; }
    public void setPlato(Long plato) { this.plato = plato; }
    public Long getInsumo() { return insumo; }
    public void setInsumo(Long insumo) { this.insumo = insumo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoInsumoId that = (PlatoInsumoId) o;
        return Objects.equals(plato, that.plato) && Objects.equals(insumo, that.insumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plato, insumo);
    }
}