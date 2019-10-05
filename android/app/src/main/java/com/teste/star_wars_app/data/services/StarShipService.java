package com.teste.star_wars_app.data.services;

import com.teste.star_wars_app.data.dto.PageDTO;
import com.teste.star_wars_app.data.models.StarShip;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarShipService {

    @GET("starships")
    Call<PageDTO<StarShip>> findAll(@Query("page") int page);

    @GET("starships/{id}")
    Call<StarShip> findOne(@Path("id") int starshipId);
}
