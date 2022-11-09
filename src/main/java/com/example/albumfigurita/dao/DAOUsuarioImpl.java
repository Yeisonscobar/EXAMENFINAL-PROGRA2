
package com.example.albumfigurita.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.albumfigurita.dto.UsuarioDTO;
import com.example.albumfigurita.interfaces.DAOUsuario;
import com.example.albumfigurita.model.Usuario;

import java.util.ArrayList;


public class DAOUsuarioImpl extends DatabaseHandler implements DAOUsuario {

    public DAOUsuarioImpl(Context context) {
        super(context);
    }

    @Override
    public boolean registrar(Usuario us) throws Exception {
        boolean band = false;
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("INSERT INTO Usuario(nombre,apellido,user,contrasenia,correo) VALUES (?,?,?,?,?)");
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getUser());
            st.setString(4, us.getContrasenia());
            st.setString(5, us.getCorreo());
            st.executeUpdate();
            band = true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrarConecion();
        }

        return band;
    }

    @Override
    public boolean modificar(Usuario us) throws Exception {
        boolean band = false;
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("UPDATE Usuario SET nombre=?,apellido=?,user=?,contrasenia=?,correo=? WHERE id=?");
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getUser());
            st.setString(4, us.getContrasenia());
            st.setString(5, us.getCorreo());
            st.setInt(6, us.getId());
            st.executeUpdate();
            band = true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrarConecion();
        }

        return band;
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        boolean band = false;

        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("DELETE FROM Usuario WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();
            band = true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrarConecion();
        }

        return band;
    }

    @Override
    public ArrayList<Usuario> listar() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("SELECT * FROM usuario");
            Cursor rs = st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                Usuario us = new Usuario();
                us.setId(rs.getInt(rs.getColumnIndexOrThrow("id")));
                us.setNombre(rs.getString(rs.getColumnIndexOrThrow("nombre")));
                us.setApellido(rs.getString(rs.getColumnIndexOrThrow("apellido")));
                us.setUser(rs.getString(rs.getColumnIndexOrThrow("user")));
                us.setContrasenia(rs.getString(rs.getColumnIndexOrThrow("contrasenia")));
                us.setCorreo(rs.getString(rs.getColumnIndexOrThrow("correo")));
                usuarios.add(us);
                rs.moveToNext();
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrarConecion();
        }
        return usuarios;
    }

    @Override
    public Usuario login(String user, String contrasenia) throws Exception {
        Usuario us = null;
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("SELECT * FROM usuario WHERE user=? and contrasenia=?");

            st.setString(1, user);
            st.setString(2, contrasenia);

            Cursor rs = st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                us = new Usuario();
                us.setId(rs.getInt(rs.getColumnIndexOrThrow("id")));
                us.setNombre(rs.getString(rs.getColumnIndexOrThrow("nombre")));
                us.setApellido(rs.getString(rs.getColumnIndexOrThrow("apellido")));
                us.setUser(rs.getString(rs.getColumnIndexOrThrow("user")));
                us.setContrasenia(rs.getString(rs.getColumnIndexOrThrow("contrasenia")));
                us.setCorreo(rs.getString(rs.getColumnIndexOrThrow("correo")));

                rs.moveToNext();
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            this.cerrarConecion();
        }
        return us;
    }

    @Override
    public Usuario obtenerUsuario(int id) throws Exception {
        Usuario us = null;
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("SELECT * FROM usuario WHERE id=?");
            st.setInt(1, id);

            Cursor rs = st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                us = new Usuario();
                us.setId(rs.getInt(rs.getColumnIndexOrThrow("id")));
                us.setNombre(rs.getString(rs.getColumnIndexOrThrow("nombre")));
                us.setApellido(rs.getString(rs.getColumnIndexOrThrow("apellido")));
                us.setUser(rs.getString(rs.getColumnIndexOrThrow("user")));
                us.setContrasenia(rs.getString(rs.getColumnIndexOrThrow("contrasenia")));
                us.setCorreo(rs.getString(rs.getColumnIndexOrThrow("correo")));
                rs.moveToNext();
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrarConecion();
        }
        return us;
    }


    @Override
    public boolean existeUsuario(Usuario us) throws Exception {
        boolean bandera = false;
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("SELECT * FROM usuario WHERE user=?");
            st.setString(1, us.getUser());
            Cursor rs = st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                bandera = true;
                rs.moveToNext();
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrarConecion();
        }
        return bandera;
    }

    @Override
    public UsuarioDTO loginDTO(String user, String contrasenia) throws Exception {
        UsuarioDTO us = null;
        try {
            this.Conectar();
            PreparedStatement st = prepareStatement("SELECT * FROM usuario WHERE user=? and contrasenia=?");

            st.setString(1, user);
            st.setString(2, contrasenia);

            Cursor rs = st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                us = new UsuarioDTO();
                us.setUser(rs.getString(rs.getColumnIndexOrThrow("user")));
                us.setContrasenia(rs.getString(rs.getColumnIndexOrThrow("contrasenia")));
                rs.moveToNext();
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            this.cerrarConecion();
        }
        return us;
    }

    @Override
    public boolean existeUsuario(String usuario, String password) throws Exception {
        boolean bandera = false;
        try {
            this.Conectar();
            String sql = "SELECT * FROM usuario WHERE user=? and contrasenia=?";
            PreparedStatement st = prepareStatement(sql);
            st.setString(1, usuario);
            st.setString(2, password);
            Cursor rs = st.executeQuery();

            rs.moveToFirst();
            while (!rs.isAfterLast()) {
                bandera = true;
                rs.moveToNext();
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            this.cerrarConecion();
        }
        return bandera;
    }


}
