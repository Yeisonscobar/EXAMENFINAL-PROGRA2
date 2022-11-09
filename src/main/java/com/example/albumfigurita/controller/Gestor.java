package com.example.albumfigurita.controller;

import android.content.Context;
import android.util.Log;

import com.example.albumfigurita.dao.DAOUsuarioImpl;
import com.example.albumfigurita.dto.UsuarioDTO;
import com.example.albumfigurita.interfaces.DAOUsuario;

public class Gestor {
    private Context context;
    private DAOUsuario daoUsuario;

    public Gestor(Context context) {
        this.daoUsuario = null;
        this.context = context;
    }

    public void iniciar(){
        try {
            this.daoUsuario = new DAOUsuarioImpl(context);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean verifiarUsuario(String usuario, String pass) {
        boolean flag = false;

        try {
            if (daoUsuario != null) {
                flag = daoUsuario.existeUsuario(usuario, pass);
            } else {
                Log.e("OBJECT : ", "nulll");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public UsuarioDTO obtenerUsuario(String usuario, String pass) {
        UsuarioDTO obj = new UsuarioDTO();

        try {
            obj = daoUsuario.loginDTO(usuario, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    public boolean validar(String usuario, String pass) {
        boolean flag = true;

        if (usuario.trim().isEmpty()) {
            flag = false;
        }

        if (pass.trim().isEmpty()) {
            flag = false;
        }

        return flag;
    }
}
