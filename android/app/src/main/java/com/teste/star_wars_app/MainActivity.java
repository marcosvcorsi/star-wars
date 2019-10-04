package com.teste.star_wars_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.google.gson.Gson;
import com.teste.star_wars_app.data.models.People;
import com.teste.star_wars_app.data.services.PeopleService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testApi();
    }

    private void testApi(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        try {
            PeopleService peopleService = retrofit.create(PeopleService.class);

            Call<People> call = peopleService.getPeople(1);

            People people = call.execute().body();

            Log.i("Teste", "OK");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
