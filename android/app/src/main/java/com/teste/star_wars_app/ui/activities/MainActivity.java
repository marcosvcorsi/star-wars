package com.teste.star_wars_app.ui.activities;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.teste.star_wars_app.R;
import com.teste.star_wars_app.ui.adapters.ViewPagerAdapter;
import com.teste.star_wars_app.ui.fragments.PeopleFragment;
import com.teste.star_wars_app.ui.fragments.PlanetsFragment;
import com.teste.star_wars_app.ui.fragments.StarShipsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        ViewPagerAdapter adapter = new ViewPagerAdapter( getSupportFragmentManager() );
        adapter.add( new PeopleFragment() , "People");
        adapter.add( new PlanetsFragment() , "Planets");
        adapter.add( new StarShipsFragment() , "Starships");

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}
