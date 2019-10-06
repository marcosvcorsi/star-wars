package com.teste.star_wars_app.ui.fragments;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.teste.star_wars_app.R;

public abstract class FavoriteListFragment extends Fragment {

    protected ListView listView;
    protected ProgressBar spinner;

    protected int currentPage = 1;
    protected boolean isLoading = false;

    protected void loadComponents(int listViewId){
        this.listView = getView().findViewById(listViewId);
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            public void onScrollStateChanged(AbsListView view, int scrollState) {


            }

            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0)
                {
                    loadOnScroll();
                }
            }
        });

        this.spinner = getView().findViewById(R.id.progressBar);
    }

    protected void setLoading(boolean loading){
        isLoading = loading;

        if(isLoading){
            spinner.setVisibility(View.VISIBLE);
        } else {
            spinner.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        loadInitialData();
    }

    protected void showMessage(String msg){
        Toast toast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public abstract void loadInitialData();

    public abstract void loadOnScroll();
}
