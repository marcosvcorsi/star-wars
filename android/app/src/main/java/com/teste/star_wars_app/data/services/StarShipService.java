package com.teste.star_wars_app.data.services;

import com.teste.star_wars_app.data.dto.PageDTO;
import com.teste.star_wars_app.data.models.StarShip;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarShipService {

    @GET("starships")
    Callback<PageDTO<StarShip>> findAll(@Query("page") int page);

    @GET("starships/{id}")
    Callback<StarShip> findOne(@Path("id") int starshipId);
}
