package com.unimagdalena.edu.co.domicilios;

import java.io.Serializable;

public class Comentario implements Serializable {

    private String usuario;
    private String comentario;

    public Comentario(String usuario, String comentario) {
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
