
package com.example.albumfigurita.interfaces;

import com.example.albumfigurita.model.Album;

import java.util.ArrayList;

public interface DAOAlbum {
    public boolean registrar(Album a) throws Exception;
    public boolean modificar(Album a) throws Exception;
    public boolean eliminar(int id) throws Exception;
    public ArrayList<Album> listar(int id) throws Exception;
}
