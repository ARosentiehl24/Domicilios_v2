package com.unimagdalena.edu.co.domicilios;

import java.io.Serializable;

public enum TipoPago implements Serializable {
    EFECTIVO("Efectivo"),
    CREDITO("Credito"),
    DEBITO("Debito");

    private String nombre;

    TipoPago(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
