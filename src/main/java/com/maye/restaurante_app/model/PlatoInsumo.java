package com.maye.restaurante_app.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plato_insumo")
@IdClass(PlatoInsumoId.class)
public class PlatoInsumo {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_plato")
    private Plato plato;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_insumo")
    private Insumo insumo;

    private Integer cantidadUsada;

    // Getters y Setters
    public Plato getPlato() { return plato; }
    public void setPlato(Plato plato) { this.plato = plato; }
    public Insumo getInsumo() { return insumo; }
    public void setInsumo(Insumo insumo) { this.insumo = insumo; }
    public Integer getCantidadUsada() { return cantidadUsada; }
    public void setCantidadUsada(Integer cantidadUsada) { this.cantidadUsada = cantidadUsada; }
}