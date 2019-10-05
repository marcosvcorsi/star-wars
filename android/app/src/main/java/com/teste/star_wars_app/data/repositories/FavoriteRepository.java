package com.teste.star_wars_app.data.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.teste.star_wars_app.data.helper.DBHelper;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;

import java.util.ArrayList;
import java.util.List;

public class FavoriteRepository {

    protected DBHelper dbHelper;

    protected Context context;

    public FavoriteRepository(Context context){
        this.context = context;
        this.dbHelper = new DBHelper(context);
    }

    public Long save(Favorite favorite){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Long id = db.insert("favorite", null, getContentValues(favorite));
        db.close();

        return id;
    }

    public Favorite findByUrlAndType(String url, FavoriteType type){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM favorite WHERE url = ? and type = ?",
                new String[]{url, type.toString()});

        Favorite favorite = null;

        if(cursor != null & cursor.getCount() > 0){
            cursor.moveToFirst();

            favorite = createFavorite(cursor);

            cursor.close();


        }

        db.close();

        return favorite;
    }

    public void update(Favorite favorite){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.update("favorite", getContentValues(favorite), "id = ?", new String[]{favorite.getId().toString()});
        db.close();
    }

    public List<Favorite> findAll(Integer type){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM favorite WHERE type = ?",
                new String[]{type.toString()});

        List<Favorite> favoriteList = new ArrayList<>();

        if(cursor != null){
            while (cursor.moveToNext()){
                Favorite favorite = createFavorite(cursor);

                favoriteList.add(favorite);
            }

            cursor.close();
        }

        db.close();

        return favoriteList;
    }

    private Favorite createFavorite(Cursor cursor){
        Favorite favorite = new Favorite();

        favorite.setId(cursor.getLong(cursor.getColumnIndex("id")));
        favorite.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        favorite.setComment(cursor.getString(cursor.getColumnIndex("comment")));

        int nrStatus = cursor.getInt(cursor.getColumnIndex("status"));
        favorite.setStatus(nrStatus == 1);

        int idType = cursor.getInt(cursor.getColumnIndex("type"));
        favorite.setType(FavoriteType.values()[idType]);

        return favorite;
    }

    private ContentValues getContentValues(Favorite favorite){
        ContentValues contentValues = new ContentValues();

        contentValues.put("url", favorite.getUrl());
        contentValues.put("comment", favorite.getComment());
        contentValues.put("type", favorite.getType().ordinal());
        contentValues.put("status", favorite.getStatus());

        return contentValues;
    }
}
