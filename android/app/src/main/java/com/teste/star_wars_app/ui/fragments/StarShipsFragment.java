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
import com.teste.star_wars_app.data.models.StarShip;
import com.teste.star_wars_app.data.services.StarShipService;
import com.teste.star_wars_app.ui.adapters.StarShipListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarShipsFragment extends FavoriteListFragment {

    private StarShipListAdapter adapter;
    private StarShipService starShipService;

    private List<StarShip> starShipList = new ArrayList<>();
    private PageDTO<StarShip> pageDTO;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadComponents(R.id.listViewStarShips);

        this.adapter = new StarShipListAdapter(getContext(), starShipList);
        this.listView.setAdapter(this.adapter);

        this.starShipService = (StarShipService) SWApi.createService(StarShipService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star_ships, container, false);
    }

    @Override
    public void loadInitialData() {
        if(starShipList.isEmpty()){
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

        Call<PageDTO<StarShip>> call = starShipService.findAll(currentPage);

        call.enqueue(new Callback<PageDTO<StarShip>>() {
            @Override
            public void onResponse(Call<PageDTO<StarShip>> call, Response<PageDTO<StarShip>> response) {
                setLoading(false);

                pageDTO = response.body();

                if(pageDTO != null){
                    starShipList.addAll(pageDTO.getResults());

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PageDTO<StarShip>> call, Throwable t) {
                setLoading(false);
                showMessage("Something is wrong!");

                t.printStackTrace();
            }
        });
    }

}
