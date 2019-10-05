package com.teste.star_wars_app.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SWApi {

    private static final String BASE_URL = "http://swapi.co/api/";
    private static Retrofit retrofit;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Object createService(Class service){
        return retrofit.create(service);
    }

}
