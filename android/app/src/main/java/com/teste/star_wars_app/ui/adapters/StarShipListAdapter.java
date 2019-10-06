package com.teste.star_wars_app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teste.star_wars_app.R;
import com.teste.star_wars_app.data.models.Favorite;
import com.teste.star_wars_app.data.models.FavoriteType;
import com.teste.star_wars_app.data.models.StarShip;

import java.util.List;

public class StarShipListAdapter extends FavoriteAdapter {

    private List<StarShip> dataSource;

    public StarShipListAdapter(Context context, List<StarShip> starShipList){
        super(context, FavoriteType.STARSHIPS);

        this.dataSource = starShipList;
        this.loadFavoriteList();
    }

    @Override
    public int getCount() {
        return this.dataSource.size();
    }

    @Override
    public StarShip getItem(int i) {
        return this.dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item_starships, viewGroup, false);

        final StarShip starShip = getItem(i);

        if(starShip != null){
            setExpandableAdapter(view);
            setDetails(view, starShip);

            final Favorite favorite = getFavorite(starShip.getUrl());

            setFavoriteEvents(view, favorite);
        }

        return view;
    }

    private void setDetails(View view, StarShip starShip){
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtModel = view.findViewById(R.id.txtModel);
        TextView txtManufacture = view.findViewById(R.id.txtManufacturer);
        TextView txtCostInCredits = view.findViewById(R.id.txtCostInCredits);
        TextView txtLength = view.findViewById(R.id.txtLength);
        TextView txtMaxAtmSpeed = view.findViewById(R.id.txtMaxAtmospheringSpeed);
        TextView txtCrew = view.findViewById(R.id.txtCrew);
        TextView txtPassengers = view.findViewById(R.id.txtPassengers);
        TextView txtCargoCapacity = view.findViewById(R.id.txtCargoCapacity);
        TextView txtConsumables = view.findViewById(R.id.txtConsumables);
        TextView txtHyperdriveRating = view.findViewById(R.id.txtHyperdriveRating);
        TextView txtMglt = view.findViewById(R.id.txtMglt);
        TextView txtStarshipClass = view.findViewById(R.id.txtStarshipClass);

        txtName.setText(starShip.getName());
        txtModel.setText(starShip.getModel());
        txtManufacture.setText(starShip.getManufacturer());
        txtCostInCredits.setText(starShip.getCostInCredits());
        txtLength.setText(starShip.getLength());
        txtMaxAtmSpeed.setText(starShip.getMaxAtmospheringSpeed());
        txtCrew.setText(starShip.getCrew());
        txtPassengers.setText(starShip.getPassengers());
        txtCargoCapacity.setText(starShip.getCargoCapacity());
        txtConsumables.setText(starShip.getConsumables());
        txtHyperdriveRating.setText(starShip.getHyperDriveRating());
        txtMglt.setText(starShip.getMglt());
        txtStarshipClass.setText(starShip.getStarShipClass());
    }
}
