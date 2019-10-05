package com.teste.star_wars_app.utils;

import com.teste.star_wars_app.data.models.Favorite;

import java.util.List;

public class FavoriteUtils {

    public static Favorite getFavoriteByUrl(List<Favorite> favoriteList, String url){
        return favoriteList.stream()
                           .filter(f -> f.getUrl().equals(url))
                           .findFirst().orElse(null);
    }
}
