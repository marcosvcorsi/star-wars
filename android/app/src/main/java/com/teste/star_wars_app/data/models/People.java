package com.teste.star_wars_app.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People implements Serializable {

    private String name;

    private String height;

    private String mass;

    @SerializedName("hair_color")
    private String hairColor;

    @SerializedName("skin_color")
    private String skinColor;

    @SerializedName("eye_color")
    private String eyeColor;

    @SerializedName("birth_year")
    private String birthYear;

    private String gender;

    @SerializedName("homeworld")
    private String homeWorldUrl;

    @SerializedName("films")
    private List<String> filmsUrl;

    @SerializedName("vehicles")
    private List<String> vehiclesUrl;

    @SerializedName("starships")
    private List<String> starShipsUrl;

    private String created;

    private String edited;

    private String url;
}
