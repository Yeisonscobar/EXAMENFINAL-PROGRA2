
package com.example.albumfigurita.model;


public class Jugador {
    private int codJugador;
    private int codPais;
    private int cod;
    private String nombre;
    private String posicion;
    private int edad;
    private String imagen;

    public Jugador() {
    }

    public Jugador(int codPais, int cod, String nombre, String posicion, int edad, String imagen) {
        this.codPais = codPais;
        this.cod = cod;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
        this.imagen = imagen;
    }

    public Jugador(int codJugador, int codPais, int cod, String nombre, String posicion, int edad, String imagen) {
        this.codJugador = codJugador;
        this.codPais = codPais;
        this.cod = cod;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
        this.imagen = imagen;
    }

    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
