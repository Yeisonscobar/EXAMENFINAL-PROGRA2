
package com.example.albumfigurita.dao;

import android.content.Context;
import android.database.Cursor;

import com.example.albumfigurita.interfaces.DAOAlbum;
import com.example.albumfigurita.model.Album;

import java.util.ArrayList;

public class DAOAlbumImpl extends Conexion implements DAOAlbum {

    public DAOAlbumImpl(Context context) {
        super(context);
    }

    @Override
    public boolean registrar(Album a) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("INSERT INTO album(nombreAlbum,anio,id) VALUES (?,?,?)");
            st.setString(1, a.getNombre());
            st.setInt(2, a.getAnio());
            st.setInt(3, a.getIdUsuario());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Album a) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("UPDATE album SET nombreAlbum=?,anio=? WHERE idAlbum=?");
            st.setString(1, a.getNombre());
            st.setInt(2, a.getAnio());
            st.setInt(3, a.getIdAlbum());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }           
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("DELETE FROM album WHERE idAlbum=?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion(); 
        }  
    }

    @Override
    public ArrayList<Album> listar(int id) throws Exception {
        ArrayList<Album> albunes= new ArrayList<Album>();
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("SELECT * FROM album WHERE id=?");
            st.setInt(1, id);
            Cursor rs=st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                Album al= new Album();
                al.setIdAlbum(rs.getInt(rs.getColumnIndexOrThrow("idAlbum")));
                al.setIdUsuario(rs.getInt(rs.getColumnIndexOrThrow("id")));
                al.setNombre(rs.getString(rs.getColumnIndexOrThrow("nombreAlbum")));
                al.setAnio(rs.getInt(rs.getColumnIndexOrThrow("anio")));
                albunes.add(al);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return albunes;
    }
    
}
