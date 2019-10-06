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
import com.teste.star_wars_app.data.models.People;
import com.teste.star_wars_app.data.services.PeopleService;
import com.teste.star_wars_app.ui.adapters.PeopleListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeopleFragment extends Fragment {

    private ListView listView;
    private ProgressBar spinner;

    private PeopleListAdapter adapter;

    private PeopleService peopleService;
    private List<People> peopleList = new ArrayList<>();

    private PageDTO<People> pageDTO;
    private int currentPage = 1;
    private boolean isLoading = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.listView = getView().findViewById(R.id.listViewPeople);
        this.adapter = new PeopleListAdapter(getContext(), peopleList);
        this.listView.setAdapter(this.adapter);

        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            public void onScrollStateChanged(AbsListView view, int scrollState) {


            }

            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0)
                {
                    if(!isLoading && pageDTO.hasNext() )
                    {
                        currentPage++;
                        //loadData();
                    }
                }
            }
        });

        this.spinner = getView().findViewById(R.id.progressBar);

        this.peopleService = (PeopleService) SWApi.createService(PeopleService.class);
        this.loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false);
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
                t.printStackTrace();
            }
        });
    }
}
