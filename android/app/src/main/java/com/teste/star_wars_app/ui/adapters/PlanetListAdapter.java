package com.teste.star_wars_app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;
import com.teste.star_wars_app.data.models.Planet;

import java.util.List;

public class PlanetListAdapter extends FavoriteAdapter {

    private List<Planet> dataSource;

    public PlanetListAdapter(Context context, List<Planet> planetList){
        super(context, FavoriteType.PLANETS);

        this.dataSource = planetList;
    }

    @Override
    public int getCount() {
        return this.dataSource.size();
    }

    @Override
    public Planet getItem(int i) {
        return this.dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item_planets, viewGroup, false);

        final Planet planet = getItem(i);

        if(planet != null){
            setExpandableAdapter(view);
            setDetails(view, planet);

            final Favorite favorite = getFavorite(planet.getUrl());

            setFavoriteEvents(view, favorite);
        }

        return view;
    }

    private void setDetails(View view, Planet planet){
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtRotationPeriod = view.findViewById(R.id.txtRotationPeriod);
        TextView txtOrbitalPeriod = view.findViewById(R.id.txtOrbitalPeriod);
        TextView txtDiameter = view.findViewById(R.id.txtDiameter);
        TextView txtClimate = view.findViewById(R.id.txtClimate);
        TextView txtGravity = view.findViewById(R.id.txtGravity);
        TextView txtTerrain = view.findViewById(R.id.txtTerrain);
        TextView txtSurfaceWater = view.findViewById(R.id.txtSurfaceWater);
        TextView txtPopulation = view.findViewById(R.id.txtPopulation);

        txtName.setText(planet.getName());
        txtRotationPeriod.setText(planet.getRotationPeriod());
        txtOrbitalPeriod.setText(planet.getOrbitalPeriod());
        txtDiameter.setText(planet.getDiameter());
        txtClimate.setText(planet.getClimate());
        txtGravity.setText(planet.getGravity());
        txtTerrain.setText(planet.getTerrain());
        txtSurfaceWater.setText(planet.getSurfaceWater());
        txtPopulation.setText(planet.getPopulation());
    }
}
