package com.teste.star_wars_app.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;
import com.teste.star_wars_app.data.repositories.FavoriteRepository;
import com.teste.star_wars_app.utils.FavoriteUtils;

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
        this.loadFavoriteList();
    }

    protected void loadFavoriteList(){
        this.favoriteList = this.favoriteRepository.findAll(favoriteType.ordinal());
    }

    protected void onClickFav(Favorite favorite, ImageView imgView, String name){
        favorite.setStatus(!favorite.getStatus());
        setImageViewByStatus(imgView, favorite.getStatus());

        this.saveOrUpdate(favorite);

        String info = favorite.getStatus() ? name + " added to favorites!" : name + " removed from favorites!";
        showInfo(info);
    }

    protected void setImageViewByStatus(ImageView imageView, Boolean status){
        if(status){
            imageView.setImageResource(R.drawable.ic_star);
        } else {
            imageView.setImageResource(R.drawable.ic_star_border);
        }
    }

    protected void hideOrShowDetails(final TableLayout tabDetails){
        if(tabDetails.getVisibility() == View.GONE){
            tabDetails.setVisibility(View.VISIBLE);
        } else {
            tabDetails.setVisibility(View.GONE);
        }
    }

    protected void onClickSend(Favorite favorite,
                               EditText editText,
                               TextView txtComments,
                               String name){
        String comment = editText.getText().toString();
        favorite.setComment(comment);
        txtComments.setText(comment);

        this.saveOrUpdate(favorite);

        editText.setText("");

        showInfo("Comment added for " + name + "!");
    }

    private void showInfo(String message){
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void saveOrUpdate(Favorite favorite){
        favoriteRepository.saveOrUpdate(favorite);

        int index = favoriteList.indexOf(favorite);

        if(index == -1){
            favoriteList.add(favorite);
        }
    }

    protected Favorite getFavorite(String url){
        Favorite favorite = FavoriteUtils.getFavoriteByUrl(favoriteList, url);

        if(favorite == null){
            favorite = new Favorite();

            favorite.setUrl(url);
            favorite.setStatus(false);
            favorite.setType(favoriteType);
        }

        return favorite;
    }

    protected void setExpandableAdapter(View view){
        final TableLayout tabDetails = view.findViewById(R.id.tabDetails);
        tabDetails.setVisibility(View.GONE);
        view.setOnClickListener((View v) -> hideOrShowDetails(tabDetails));
    }

    protected void setFavoriteEvents(View view, final Favorite favorite, String name){
        TextView txtComments = view.findViewById(R.id.txtComments);

        if(favorite.getComment() != null && !favorite.getComment().isEmpty()){
            txtComments.setText(favorite.getComment());
        }

        final EditText editComments = view.findViewById(R.id.editComments);

        final Button btnSend = view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener((View v) -> {
            onClickSend(favorite, editComments, txtComments, name);
        });

        final ImageView imgFav = view.findViewById(R.id.imgFav);
        imgFav.setOnClickListener((View v) -> {
            onClickFav(favorite, imgFav, name);
        });

        setImageViewByStatus(imgFav, favorite.getStatus());
    }
}
