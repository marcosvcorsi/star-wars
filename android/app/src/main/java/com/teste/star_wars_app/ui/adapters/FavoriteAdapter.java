package com.teste.star_wars_app.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;
import com.teste.star_wars_app.data.repositories.FavoriteRepository;

import java.util.List;

public abstract class FavoriteAdapter extends BaseAdapter {

    protected Context context;
    protected List<Favorite> favoriteList;
    protected FavoriteRepository favoriteRepository;
    protected FavoriteType favoriteType;

    public FavoriteAdapter(Context context, FavoriteType type) {
        this.context = context;
        this.favoriteType = type;

        this.favoriteRepository = new FavoriteRepository(context);
    }

    protected void loadFavoriteList(){
        this.favoriteList = this.favoriteRepository.findAll(favoriteType.ordinal());
    }

    protected void onClickFav(Favorite favorite, ImageView imgView){
        favorite.setStatus(!favorite.getStatus());

        favoriteRepository.saveOrUpdate(favorite);

        setImageViewByStatus(imgView, favorite.getStatus());

        this.loadFavoriteList();
    }

    protected void setImageViewByStatus(ImageView imageView, Boolean status){
        if(status){
            imageView.setImageResource(R.drawable.ic_star);
        } else {
            imageView.setImageResource(R.drawable.ic_star_border);
        }
    }

    private void hideOrShowDetails(final TableLayout tabDetails){
        if(tabDetails.getVisibility() == View.GONE){
            tabDetails.setVisibility(View.VISIBLE);
        } else {
            tabDetails.setVisibility(View.GONE);
        }
    }

}
