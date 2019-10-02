package com.teste.star_wars_app.data.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Planet implements Serializable {

    private String name;

    private Integer rotationPeriod;

    private Integer orbitalPeriod;

    private Integer diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private Integer surfaceWater;

    private Long population;

    // TO-DO lists
}
