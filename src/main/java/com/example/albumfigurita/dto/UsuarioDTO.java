package com.example.albumfigurita.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private String user;
    private String contrasenia;

    public UsuarioDTO() {
        this.user = null;
        this.contrasenia = null;
    }

    public UsuarioDTO(String user, String contrasenia) {
        this.user = user;
        this.contrasenia = contrasenia;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "user='" + user + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
