
package com.example.albumfigurita.interfaces;

import com.example.albumfigurita.dto.UsuarioDTO;
import com.example.albumfigurita.model.Usuario;

import java.util.ArrayList;

public interface DAOUsuario {
    
    public Usuario login(String user, String contrasenia) throws Exception;
    public boolean registrar(Usuario us) throws Exception;
    public boolean modificar(Usuario us) throws Exception;
    public boolean eliminar(int id) throws Exception;
    public ArrayList<Usuario> listar() throws Exception;
    public boolean existeUsuario(Usuario us) throws Exception;
    public boolean existeUsuario(String usuario, String password) throws Exception;
    public Usuario obtenerUsuario(int id) throws Exception;
    UsuarioDTO loginDTO(String usuario, String pass) throws Exception;
}
