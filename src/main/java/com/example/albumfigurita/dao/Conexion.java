package com.example.albumfigurita.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;


/**
 * Created by NgocTri on 11/7/2015.
 */
public class Conexion extends SQLiteOpenHelper {
    // System path of application database.
    private static final String URL = "estampitaMundial.db";
    protected SQLiteDatabase conexion;

    public Conexion(Context context){
            super(context, "estampitaMundial.db", null, 1);
    }

    public SQLiteDatabase openDataBaseReady() throws SQLException {

        // Opens the database
        String myPath = Environment.getExternalStorageDirectory().getPath() + File.separator + URL;
        conexion = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READONLY);
        return conexion;
    }

    public SQLiteDatabase Conectar() throws SQLException {

        // Opens the database
        String myPath = Environment.getExternalStorageDirectory().getPath() + File.separator + URL;
        conexion = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        return conexion;
    }

    public synchronized void cerrarConecion() {
        if (conexion != null)
            conexion.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public PreparedStatement prepareStatement(String sql) {
        return new PreparedStatement(conexion, sql);
    }
}
