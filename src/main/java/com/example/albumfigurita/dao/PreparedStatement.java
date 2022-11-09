package com.example.albumfigurita.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

public class PreparedStatement {
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteStatement sqLiteStatement;
    private String sql;
    private List<String> lista;

    public PreparedStatement(SQLiteDatabase compileStatement, String sql) {
        this.sqLiteDatabase = compileStatement;
        this.sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        this.sql = sql;
        this.lista = new ArrayList<>();
    }

    public void setInt(int index, int valor) {
        lista.add(index - 1, String.valueOf(valor));
        sqLiteStatement.bindLong(index, valor);
    }

    public void setString(int index, String valor) {
        lista.add(index - 1, valor);
        sqLiteStatement.bindString(index, valor);
    }

    public void executeUpdate() {
        sqLiteStatement.executeUpdateDelete();
    }

    public Cursor executeQuery() {
        String[] v = new String[lista.size()];
        Cursor cursor = sqLiteDatabase.rawQuery(sql, lista.toArray(v));
        lista.clear();

        return cursor;
    }

    public void close() {
        sqLiteStatement.close();
        sqLiteDatabase.close();
    }
}
