package com.unimagdalena.edu.co.domicilios;

import java.io.Serializable;

public class Locacion implements Serializable {

    private double latitud;
    private double longitud;

    public Locacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
