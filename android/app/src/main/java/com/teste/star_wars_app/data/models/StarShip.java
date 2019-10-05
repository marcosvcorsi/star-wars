package com.teste.star_wars_app.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperDriveRating() {
        return hyperDriveRating;
    }

    public void setHyperDriveRating(String hyperDriveRating) {
        this.hyperDriveRating = hyperDriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getStarShipClass() {
        return starShipClass;
    }

    public void setStarShipClass(String starShipClass) {
        this.starShipClass = starShipClass;
    }

    public List<String> getPilotsUrl() {
        return pilotsUrl;
    }

    public void setPilotsUrl(List<String> pilotsUrl) {
        this.pilotsUrl = pilotsUrl;
    }

    public List<String> getFilmsUrl() {
        return filmsUrl;
    }

    public void setFilmsUrl(List<String> filmsUrl) {
        this.filmsUrl = filmsUrl;
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
