package com.teste.star_wars_app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;
import com.teste.star_wars_app.data.models.People;

import java.util.List;

public class PeopleListAdapter extends FavoriteAdapter {

    private List<People> dataSource;

    public PeopleListAdapter(Context context, List<People> peopleList){
        super(context, FavoriteType.PEOPLE);

        this.dataSource = peopleList;

        this.loadFavoriteList();
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

        final People people = getItem(i);

        if(people != null){
            setExpandableAdapter(view);
            setDetails(view, people);

            final Favorite favorite = getFavorite(people.getUrl());

            setFavoriteEvents(view, favorite);
        }

        return view;
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
}
