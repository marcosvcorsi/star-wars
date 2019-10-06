package com.teste.star_wars_app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.api.SWApi;
import com.teste.star_wars_app.data.dto.PageDTO;
import com.teste.star_wars_app.data.models.Planet;
import com.teste.star_wars_app.data.services.PlanetService;
import com.teste.star_wars_app.ui.adapters.PlanetListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetsFragment extends FavoriteListFragment {

    private PlanetListAdapter adapter;
    private PlanetService planetService;

    private List<Planet> planetList = new ArrayList<>();
    private PageDTO<Planet> pageDTO;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadComponents(R.id.listViewPlanets);

        this.adapter = new PlanetListAdapter(getContext(), planetList);
        this.listView.setAdapter(this.adapter);

        this.planetService = (PlanetService) SWApi.createService(PlanetService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planets, container, false);
    }

    @Override
    public void loadInitialData() {
        if(planetList.isEmpty()){
            loadData();
        }
    }

    @Override
    public void loadOnScroll() {
        if(!isLoading && pageDTO.hasNext() )
        {
            currentPage++;
            loadData();
        }
    }

    private void loadData() {
        setLoading(true);

        Call<PageDTO<Planet>> call = planetService.findAll(currentPage);

        call.enqueue(new Callback<PageDTO<Planet>>() {
            @Override
            public void onResponse(Call<PageDTO<Planet>> call, Response<PageDTO<Planet>> response) {
                setLoading(false);

                pageDTO = response.body();

                if(pageDTO != null){
                    planetList.addAll(pageDTO.getResults());

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PageDTO<Planet>> call, Throwable t) {
                setLoading(false);
                showMessage("Something is wrong!");

                t.printStackTrace();
            }
        });
    }

}
