package com.teste.star_wars_app.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeWorldUrl() {
        return homeWorldUrl;
    }

    public void setHomeWorldUrl(String homeWorldUrl) {
        this.homeWorldUrl = homeWorldUrl;
    }

    public List<String> getFilmsUrl() {
        return filmsUrl;
    }

    public void setFilmsUrl(List<String> filmsUrl) {
        this.filmsUrl = filmsUrl;
    }

    public List<String> getVehiclesUrl() {
        return vehiclesUrl;
    }

    public void setVehiclesUrl(List<String> vehiclesUrl) {
        this.vehiclesUrl = vehiclesUrl;
    }

    public List<String> getStarShipsUrl() {
        return starShipsUrl;
    }

    public void setStarShipsUrl(List<String> starShipsUrl) {
        this.starShipsUrl = starShipsUrl;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
