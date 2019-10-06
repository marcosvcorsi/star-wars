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
import com.teste.star_wars_app.data.models.People;
import com.teste.star_wars_app.data.services.PeopleService;
import com.teste.star_wars_app.ui.adapters.PeopleListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeopleFragment extends FavoriteListFragment {

    private PeopleListAdapter adapter;
    private PeopleService peopleService;

    private List<People> peopleList = new ArrayList<>();
    private PageDTO<People> pageDTO = new PageDTO<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadComponents(R.id.listViewPeople);

        this.adapter = new PeopleListAdapter(getContext(), peopleList);
        this.listView.setAdapter(this.adapter);

        this.peopleService = (PeopleService) SWApi.createService(PeopleService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false);
    }

    @Override
    public void loadInitialData() {
        if(peopleList.isEmpty()){
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

        Call<PageDTO<People>> call = peopleService.findAll(currentPage);
        call.enqueue(new Callback<PageDTO<People>>() {
            @Override
            public void onResponse(Call<PageDTO<People>> call, Response<PageDTO<People>> response) {
                setLoading(false);

                pageDTO = response.body();
                peopleList.addAll(pageDTO.getResults());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PageDTO<People>> call, Throwable t) {
                setLoading(false);
                showMessage("Something is wrong!");

                t.printStackTrace();
            }
        });
    }
}
