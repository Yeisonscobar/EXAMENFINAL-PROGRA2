
package com.example.albumfigurita.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.albumfigurita.interfaces.DAOJugador;
import com.example.albumfigurita.model.Jugador;

import java.util.ArrayList;


public class DAOJugadorImpl extends Conexion implements DAOJugador {

    public DAOJugadorImpl(Context context) {
        super(context);
    }

    @Override
    public boolean registrar(Jugador j) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("INSERT INTO jugador(idPais,codJug,nombre,posicion,edad,imagen) VALUES (?,?,?,?,?,?)");
            st.setInt(1, j.getCodPais());
            st.setInt(2, j.getCod());
            st.setString(3, j.getNombre());
            st.setString(4,j.getPosicion());
            st.setInt(5, j.getEdad());
            st.setString(6, j.getImagen());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Jugador j) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("UPDATE jugador SET idPais=?,codJug=?,nombre=?,posicion=?,edad=?,imagen=? WHERE idJugador=?");
            st.setInt(1, j.getCodPais());
            st.setInt(2, j.getCod());
            st.setString(3, j.getNombre());
            st.setString(4,j.getPosicion());
            st.setInt(5, j.getEdad());
            st.setString(6, j.getImagen());
            st.setInt(7, j.getCodJugador());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
    }



    @Override
    public ArrayList<Jugador> listar(int idPais) throws Exception {
        ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("SELECT * FROM jugador WHERE idPais=?");
            st.setInt(1, idPais);
            Cursor rs=st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                Jugador ju= new Jugador();

                ju.setCodJugador(rs.getInt(rs.getColumnIndexOrThrow("idJugador")));
                ju.setCod(rs.getInt(rs.getColumnIndexOrThrow("codJug")));
                ju.setCodPais(rs.getInt(rs.getColumnIndexOrThrow("idPais")));
                ju.setEdad(rs.getInt(rs.getColumnIndexOrThrow("edad")));
                ju.setImagen(rs.getString(rs.getColumnIndexOrThrow("imagen")));
                ju.setNombre(rs.getString(rs.getColumnIndexOrThrow("nombre")));
                ju.setPosicion(rs.getString(rs.getColumnIndexOrThrow("posicion")));

                jugadores.add(ju);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return jugadores;
    }
    
}
