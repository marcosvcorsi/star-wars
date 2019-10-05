package com.teste.star_wars_app.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "sw_db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.createTableFavorite(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void createTableFavorite(SQLiteDatabase sqLiteDatabase){
        StringBuffer tableFavorite = new StringBuffer();

        tableFavorite.append("CREATE TABLE favorite(");
        tableFavorite.append("id INTEGER PRIMARY KEY, ");
        tableFavorite.append("url TEXT, ");
        tableFavorite.append("comment TEXT, ");
        tableFavorite.append("type INTEGER, ");
        tableFavorite.append("status INTEGER )");

        sqLiteDatabase.execSQL(tableFavorite.toString());
    }
}
