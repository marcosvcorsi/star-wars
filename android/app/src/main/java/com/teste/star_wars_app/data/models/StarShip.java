package com.teste.star_wars_app.data.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarShip implements Serializable {

    private String name;

    private String model;

    private String manufacturer;

    private Long costInCredits;

    private Integer length;

    private String maxAtmospheringSpeed;

    private Integer crew;
    
    private Integer passenger;

    private Long cargoCapacity;

    private String consumables;

    private String hyperDriveRating;

    private Integer mglt;

    private String starShipClass;

    private String pilots;
}
