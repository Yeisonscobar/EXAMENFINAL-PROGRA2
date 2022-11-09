
package com.example.albumfigurita.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String user;
    private String contrasenia;
    private String correo;
    private int id;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String user, String contrasenia, String correo, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.id = id;
    }
    

    public Usuario(String nombre, String apellido, String user, String contrasenia, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
