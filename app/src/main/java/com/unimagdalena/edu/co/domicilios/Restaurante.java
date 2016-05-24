package com.unimagdalena.edu.co.domicilios;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurante implements Serializable {

    private String nombre;
    private String categoria;
    private String direccion;
    private Integer calificacion;
    private String[] tipoPago;
    private Locacion coordenadas;
    private String imagen;
    private Double precioEnvio;
    private Boolean estado;
    private String telefono;
    private String precioMinimo;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Plato> menu;
    private Integer tiempoEntrega;

    public Restaurante(String nombre, String categoria, String direccion, Integer calificacion, String[] tipoPago, Locacion coordenadas, String imagen, Double precioEnvio, Boolean estado, String telefono, String precioMinimo, ArrayList<Comentario> comentarios, ArrayList<Plato> menu, Integer tiempoEntrega) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.direccion = direccion;
        this.calificacion = calificacion;
        this.tipoPago = tipoPago;
        this.coordenadas = coordenadas;
        this.imagen = imagen;
        this.precioEnvio = precioEnvio;
        this.estado = estado;
        this.telefono = telefono;
        this.precioMinimo = precioMinimo;
        this.comentarios = comentarios;
        this.menu = menu;
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String[] getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String[] tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Locacion getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Locacion coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(Double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(String precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<Plato> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Plato> menu) {
        this.menu = menu;
    }

    public Integer getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(Integer tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }
}
