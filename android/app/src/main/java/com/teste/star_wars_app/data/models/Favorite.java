package com.teste.star_wars_app.data.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Favorite {

    private Long id;

    private String url;

    private String comment;

    private FavoriteType type;

    private Boolean status;

}
