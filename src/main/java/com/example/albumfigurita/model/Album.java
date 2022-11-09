
package com.example.albumfigurita.model;

public class Album {
    private int idAlbum;
    private int idUsuario;
    private String nombre;
    private int anio;

    public Album() {
    }

    public Album(int idUsuario, String nombre, int anio) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.anio = anio;
    }

    public Album(int idAlbum, int idUsuario, String nombre, int anio) {
        this.idAlbum = idAlbum;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    
}
