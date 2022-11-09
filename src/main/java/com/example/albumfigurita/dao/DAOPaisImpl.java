
package com.example.albumfigurita.dao;


import android.content.Context;
import android.database.Cursor;

import com.example.albumfigurita.interfaces.DAOPais;
import com.example.albumfigurita.model.Pais;

import java.util.ArrayList;

public class DAOPaisImpl extends Conexion implements DAOPais {

    public DAOPaisImpl(Context context) {
        super(context);
    }

    @Override
    public boolean registrar(Pais p) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("INSERT INTO pais(nombrePais,abrevPais,codPais,imagen,idAlbum) VALUES (?,?,?,?,?)");
            st.setString(1, p.getNombrePais());
            st.setString(2, p.getAbrevPais());
            st.setInt(3, p.getCodPais());
            st.setString(4, p.getImg());
            st.setInt(5, p.getIdAlbum());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Pais p) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("UPDATE pais SET nombrePais=?,abrevPais=?,codPais=?,imagen=?,idAlbum=? WHERE idPais=?");
            st.setString(1, p.getNombrePais());
            st.setString(2, p.getAbrevPais());
            st.setInt(3, p.getCodPais());
            st.setString(4, p.getImg());
            st.setInt(5, p.getIdAlbum());
            st.setInt(6, p.getIdPais());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
    }

    @Override
    public ArrayList<Pais> listar(int id) throws Exception {
        ArrayList<Pais> paises= new ArrayList<Pais>();
        try{
            this.Conectar();
            PreparedStatement st= prepareStatement("SELECT * FROM pais WHERE idAlbum=?");
            st.setInt(1, id);
            Cursor rs=st.executeQuery();
            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                Pais pa= new Pais();
                pa.setIdPais(rs.getInt(rs.getColumnIndexOrThrow("idPais")));
                pa.setAbrevPais(rs.getString(rs.getColumnIndexOrThrow("abrevPais")));
                pa.setCodPais(rs.getInt(rs.getColumnIndexOrThrow("codPais")));
                pa.setIdAlbum(rs.getInt(rs.getColumnIndexOrThrow("idAlbum")));
                pa.setImg(rs.getString(rs.getColumnIndexOrThrow("imagen")));
                pa.setNombrePais(rs.getString(rs.getColumnIndexOrThrow("nombrePais")));
                paises.add(pa);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return paises;
    }
    
}
