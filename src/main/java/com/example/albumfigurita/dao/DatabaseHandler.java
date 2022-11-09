package com.example.albumfigurita.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "estampitaMundial.db";
private SQLiteDatabase sqLiteDatabase;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
        try {
            try {
                crearTablas();
                insertarRegistros();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase Conectar() throws SQLException {

        if (sqLiteDatabase == null){
            sqLiteDatabase = getWritableDatabase();
        } else{
            if (!sqLiteDatabase.isOpen()){
                sqLiteDatabase = getWritableDatabase();
            }
        }

        return sqLiteDatabase;
    }

    public synchronized void cerrarConecion() {
        if (sqLiteDatabase != null){
            this.sqLiteDatabase.close();
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        return new PreparedStatement(sqLiteDatabase, sql);
    }

    private void crearTablas() {
        String sql = "CREATE TABLE IF NOT EXISTS \"usuario\" (\n" +
                "\t\"id\"\tinteger,\n" +
                "\t\"nombre\"\tvarchar(45) NOT NULL,\n" +
                "\t\"apellido\"\tvarchar(45) NOT NULL,\n" +
                "\t\"user\"\tvarchar(45) NOT NULL,\n" +
                "\t\"contrasenia\"\tvarchar(45) NOT NULL,\n" +
                "\t\"correo\"\ttext NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"album\" (\n" +
                "\t\"idAlbum\"\tinteger,\n" +
                "\t\"nombreAlbum\"\tVARHCAR(60) NOT NULL,\n" +
                "\t\"anio\"\tinteger NOT NULL,\n" +
                "\t\"id\"\tinteger NOT NULL,\n" +
                "\tPRIMARY KEY(\"idAlbum\" AUTOINCREMENT),\n" +
                "\tCONSTRAINT \"fk_usuarios\" FOREIGN KEY(\"id\") REFERENCES \"usuario\"(\"id\") ON DELETE CASCADE\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"pais\" (\n" +
                "\t\"idPais\"\tinteger,\n" +
                "\t\"nombrePais\"\tVARCHAR(35) NOT NULL,\n" +
                "\t\"abrevPais\"\tVARCHAR(6) NOT NULL,\n" +
                "\t\"codPais\"\tinteger NOT NULL,\n" +
                "\t\"imagen\"\tVARCHAR(35) NOT NULL,\n" +
                "\t\"idAlbum\"\tinteger NOT NULL,\n" +
                "\tPRIMARY KEY(\"idPais\" AUTOINCREMENT),\n" +
                "\tCONSTRAINT \"fk_idAlbum\" FOREIGN KEY(\"idAlbum\") REFERENCES \"album\"(\"idAlbum\") ON DELETE CASCADE\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"jugador\" (\n" +
                "\t\"idJugador\"\tinteger,\n" +
                "\t\"idPais\"\tintger NOT NULL,\n" +
                "\t\"codJug\"\tinteger NOT NULL,\n" +
                "\t\"nombre\"\tVARHCAR(75) NOT NULL,\n" +
                "\t\"posicion\"\tVARCHAR(30) NOT NULL,\n" +
                "\t\"edad\"\tint NOT NULL,\n" +
                "\t\"imagen\"\tVARCHAR(60) NOT NULL,\n" +
                "\tPRIMARY KEY(\"idJugador\" AUTOINCREMENT),\n" +
                "\tCONSTRAINT \"fk_idPais\" FOREIGN KEY(\"idPais\") REFERENCES \"pais\"(\"idPais\") ON DELETE CASCADE\n" +
                ");";

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        for (String obj : sql.split(";")) {
            sqLiteDatabase.execSQL(obj);
        }

        sqLiteDatabase.close();
    }

    public void insertarRegistros() {
        String[] sqls = ("BEGIN TRANSACTION;\n" +
                "INSERT OR IGNORE INTO \"usuario\" VALUES (2,'jona','dsdsd','jona','123','sdsd');\n" +
                "INSERT OR IGNORE INTO \"usuario\" VALUES (3,'pepe','barrientos','pepe','123','pepe@gmail.com');\n" +
                "INSERT OR IGNORE INTO \"usuario\" VALUES (4,'ASAMI','SATO','AS','AS','grarlbdmirage@gmail.com');\n" +
                "INSERT OR IGNORE INTO \"album\" VALUES (2,'mundial',2016,2);\n" +
                "INSERT OR IGNORE INTO \"album\" VALUES (3,'super mundial',2018,3);\n" +
                "INSERT OR IGNORE INTO \"album\" VALUES (4,'mundial',2022,3);\n" +
                "INSERT OR IGNORE INTO \"album\" VALUES (5,'ARG',2000,4);\n" +
                "INSERT OR IGNORE INTO \"pais\" VALUES (2,'Argentina','ARG',1,'img/paises/31.png',3);\n" +
                "INSERT OR IGNORE INTO \"pais\" VALUES (3,'España','ESP',4,'img/paises/34.png',3);\n" +
                "INSERT OR IGNORE INTO \"pais\" VALUES (4,'ARG','ARG',1,'img/paises/51.png',5);\n" +
                "INSERT OR IGNORE INTO \"jugador\" VALUES (2,2,4,'Hector','Delantero',25,'img/jugadores/24.png');\n" +
                "INSERT OR IGNORE INTO \"jugador\" VALUES (3,2,12,'Ehsan','Arquero',26,'img/jugadores/212.png');\n" +
                "INSERT OR IGNORE INTO \"jugador\" VALUES (4,2,7,'Admir','Defensa',33,'img/jugadores/27.png');\n" +
                "INSERT OR IGNORE INTO \"jugador\" VALUES (5,4,1,'epele','Volante',23,'img/jugadores/41.png');\n" +
                "INSERT OR IGNORE INTO \"jugador\" VALUES (6,4,2,'yo´p','Arquero',89,'img/jugadores/42.png');\n" +
                "COMMIT;").split(";");

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.beginTransaction();
        try{
            for (String sql : sqls) {
                sqLiteDatabase.execSQL(sql);
            }
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        } catch(Exception e){
            sqLiteDatabase.close();
        }

    }
}