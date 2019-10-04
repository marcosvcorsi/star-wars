package com.teste.star_wars_app.data.services;

import com.teste.star_wars_app.data.dto.PageDTO;
import com.teste.star_wars_app.data.models.Planet;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlanetService {

    @GET("planets")
    Callback<PageDTO<Planet>> findAll(@Query("page") int page);

    @GET("planets/{id}")
    Callback<Planet> findOne(@Path("id") int planetId);
}
