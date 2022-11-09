
package com.example.albumfigurita.interfaces;

import com.example.albumfigurita.model.Jugador;

import java.util.ArrayList;

public interface DAOJugador {
    public boolean registrar(Jugador j) throws Exception;
    public boolean modificar(Jugador j) throws Exception;
    public ArrayList<Jugador> listar(int idPais) throws Exception;
}
