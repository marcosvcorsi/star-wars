package com.teste.star_wars_app.data.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People implements Serializable {

    private String name;

    private Integer height;

    private Integer mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthYear;

    private String gender;

    private String homeWorld;


    // TO-DO more
}
