package com.teste.star_wars_app.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Planet implements Serializable {

    private String name;

    @SerializedName("rotation_period")
    private String rotationPeriod;

    @SerializedName("orbital_period")
    private String orbitalPeriod;

    private String diameter;

    private String climate;

    private String gravity;

    private String terrain;

    @SerializedName("surface_water")
    private String surfaceWater;

    private String population;

    @SerializedName("residents")
    private List<String> residentsUrl;

    @SerializedName("films")
    private List<String> filmsUrl;

    private String created;

    private String edited;

    private String url;
}
