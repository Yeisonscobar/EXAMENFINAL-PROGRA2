
package com.example.albumfigurita.model;


public class Pais {
    private int idPais;
    private String nombrePais;
    private String abrevPais;
    private int codPais;
    private String img;
    private int idAlbum;

    public Pais() {
    }

    public Pais(int idPais, String nombrePais, String abrevPais, int codPais, String img, int idAlbum) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.abrevPais = abrevPais;
        this.codPais = codPais;
        this.img = img;
        this.idAlbum = idAlbum;
    }

    public Pais(String nombrePais, String abrevPais, int codPais, String img, int idAlbum) {
        this.nombrePais = nombrePais;
        this.abrevPais = abrevPais;
        this.codPais = codPais;
        this.img = img;
        this.idAlbum = idAlbum;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getAbrevPais() {
        return abrevPais;
    }

    public void setAbrevPais(String abrevPais) {
        this.abrevPais = abrevPais;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    
}
