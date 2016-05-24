package com.unimagdalena.edu.co.domicilios;

import java.io.Serializable;
import java.util.ArrayList;

public class Compra implements Serializable {

    private ArrayList<Plato> platos;
    private Double total;
    private Restaurante restaurante;

    public Compra(ArrayList<Plato> platos, Double total, Restaurante restaurante) {
        this.platos = platos;
        this.total = total;
        this.restaurante = restaurante;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
