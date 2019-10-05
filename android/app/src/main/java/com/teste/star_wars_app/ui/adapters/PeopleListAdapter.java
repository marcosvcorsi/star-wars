package com.teste.star_wars_app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;
import com.teste.star_wars_app.data.models.People;
import com.teste.star_wars_app.data.repositories.FavoriteRepository;
import com.teste.star_wars_app.utils.FavoriteUtils;

import java.util.List;

public class PeopleListAdapter extends BaseAdapter {

    private Context context;
    private List<People> dataSource;

    private List<Favorite> favoriteList;
    private FavoriteRepository favoriteRepository;

    public PeopleListAdapter(Context context, List<People> peopleList){
        this.context = context;
        this.dataSource = peopleList;

        this.favoriteRepository = new FavoriteRepository(context);
        this.loadFavoriteList();
    }

    private void loadFavoriteList(){
        this.favoriteList = this.favoriteRepository.findAll(FavoriteType.PEOPLE.ordinal());
    }

    @Override
    public int getCount() {
        return this.dataSource.size();
    }

    @Override
    public People getItem(int i) {
        return this.dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item_people, viewGroup, false);

        final TableLayout tabDetails = view.findViewById(R.id.tabDetails);
        tabDetails.setVisibility(View.GONE);

        view.setOnClickListener((View v) -> {
            hideOrShowDetails(tabDetails);
        });

        final People people = getItem(i);

        if(people != null){
            setDetails(view, people);

            final Favorite favorite = getFavorite(people);

            TextView txtComments = view.findViewById(R.id.txtComments);

            if(favorite.getComment() != null && !favorite.getComment().isEmpty()){
                txtComments.setText(favorite.getComment());
            } else {
                txtComments.setVisibility(View.GONE);
            }

            final EditText editComments = view.findViewById(R.id.editComments);

            final Button btnSend = view.findViewById(R.id.btnSend);
            btnSend.setOnClickListener((View v) -> {
                onClickSend(favorite, editComments, txtComments);
            });

            final ImageView imgFav = view.findViewById(R.id.imgFav);
            imgFav.setOnClickListener((View v) -> {
                onClickFav(favorite, imgFav);
            });

            setImageViewByStatus(imgFav, favorite.getStatus());
        }

        return view;
    }

    private void onClickSend(Favorite favorite, EditText editText, TextView txtComments){
        String comment = editText.getText().toString();
        favorite.setComment(comment);

        txtComments.setVisibility(View.VISIBLE);
        txtComments.setText(comment);

        favoriteRepository.saveOrUpdate(favorite);

        editText.setText("");
        this.loadFavoriteList();
    }

    private void onClickFav(Favorite favorite, ImageView imgView){
        favorite.setStatus(!favorite.getStatus());

        favoriteRepository.saveOrUpdate(favorite);

        setImageViewByStatus(imgView, favorite.getStatus());

        this.loadFavoriteList();
    }

    private void setImageViewByStatus(ImageView imageView, Boolean status){
        if(status){
            imageView.setImageResource(R.drawable.ic_star);
        } else {
            imageView.setImageResource(R.drawable.ic_star_border);
        }
    }

    private Favorite getFavorite(People people){
        Favorite favorite = FavoriteUtils.getFavoriteByUrl(favoriteList, people.getUrl());

        if(favorite == null){
            favorite = new Favorite();

            favorite.setUrl(people.getUrl());
            favorite.setStatus(false);
            favorite.setType(FavoriteType.PEOPLE);
        }

        return favorite;
    }

    private void setDetails(View view, People people){
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtHeight = view.findViewById(R.id.txtHeight);
        TextView txtMass = view.findViewById(R.id.txtMass);
        TextView txtHairColor = view.findViewById(R.id.txtHairColor);
        TextView txtSkinColor = view.findViewById(R.id.txtSkinColor);
        TextView txtEyeColor = view.findViewById(R.id.txtEyeColor);
        TextView txtBirthYear = view.findViewById(R.id.txtBirthYear);
        TextView txtGender = view.findViewById(R.id.txtGender);

        txtName.setText(people.getName());
        txtHeight.setText(people.getHeight());
        txtMass.setText(people.getMass());
        txtHairColor.setText(people.getHairColor());
        txtSkinColor.setText(people.getSkinColor());
        txtEyeColor.setText(people.getEyeColor());
        txtBirthYear.setText(people.getBirthYear());
        txtGender.setText(people.getGender());
    }

    private void hideOrShowDetails(final TableLayout tabDetails){
        if(tabDetails.getVisibility() == View.GONE){
            tabDetails.setVisibility(View.VISIBLE);
        } else {
            tabDetails.setVisibility(View.GONE);
        }
    }
}
