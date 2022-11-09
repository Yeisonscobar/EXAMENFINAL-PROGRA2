
package com.example.albumfigurita.interfaces;

import com.example.albumfigurita.model.Pais;

import java.util.ArrayList;

public interface DAOPais {
    public boolean registrar(Pais p) throws Exception;
    public boolean modificar(Pais p) throws Exception;
    public ArrayList<Pais> listar(int id) throws Exception;
}
