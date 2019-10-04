package com.teste.star_wars_app.data.services;

import com.teste.star_wars_app.data.dto.PageDTO;
import com.teste.star_wars_app.data.models.People;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeopleService {

    @GET("people")
    Call<PageDTO<People>> findAll(@Query("page") int page);

    @GET("people/{id}")
    Call<People> findOne(@Path("id") int peopleId);
}
