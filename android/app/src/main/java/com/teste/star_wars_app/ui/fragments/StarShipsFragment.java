package com.teste.star_wars_app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class StarShipsFragment extends Fragment {

    private ListView listView;
    private ProgressBar spinner;

    private StarShipListAdapter adapter;

    private StarShipService starShipService;
    private List<StarShip> starShipList = new ArrayList<>();

    private PageDTO<StarShip> pageDTO;
    private int currentPage = 1;
    private boolean isLoading = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.listView = getView().findViewById(R.id.listViewStarShips);
        this.adapter = new StarShipListAdapter(getContext(), starShipList);
        this.listView.setAdapter(this.adapter);

        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            public void onScrollStateChanged(AbsListView view, int scrollState) {


            }

            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount!=0)
                {
                    if(!isLoading && pageDTO.hasNext() )
                    {
                        currentPage++;
                        loadData();
                    }
                }
            }
        });

        this.spinner = getView().findViewById(R.id.progressBar);

        this.starShipService = (StarShipService) SWApi.createService(StarShipService.class);
        this.loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star_ships, container, false);
    }

    private void setLoading(boolean loading){
        isLoading = loading;

        if(isLoading){
            spinner.setVisibility(View.VISIBLE);
        } else {
            spinner.setVisibility(View.INVISIBLE);
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
                starShipList.addAll(pageDTO.getResults());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PageDTO<StarShip>> call, Throwable t) {
                setLoading(false);
                t.printStackTrace();
            }
        });
    }

}
