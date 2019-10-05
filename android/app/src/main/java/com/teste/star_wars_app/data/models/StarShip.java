package com.teste.star_wars_app.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarShip implements Serializable {

    private String name;

    private String model;

    private String manufacturer;

    @SerializedName("cost_in_credits")
    private String costInCredits;

    private String length;

    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    private String crew;
    
    private String passengers;

    @SerializedName("cargo_capacity")
    private String cargoCapacity;

    private String consumables;

    @SerializedName("hyperdrive_rating")
    private String hyperDriveRating;

    @SerializedName("MGLT")
    private String mglt;

    @SerializedName("starship_class")
    private String starShipClass;

    @SerializedName("pilots")
    private List<String> pilotsUrl;

    @SerializedName("films")
    private List<String> filmsUrl;

    private String created;

    private String edited;

    private String url;
}
