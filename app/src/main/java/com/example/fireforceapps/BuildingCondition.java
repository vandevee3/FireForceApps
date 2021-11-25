package com.example.fireforceapps;


import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;


public class BuildingCondition extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        FiremanInformationFragment firemanFragment = new FiremanInformationFragment();
        BuildingConditionFragment buildingFragment = new BuildingConditionFragment();
        TipsFragment tipsFragment = new TipsFragment();
        DontDoFragment dontDoFragment = new DontDoFragment();


        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.firemanInformation:
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firemanFragment).commit();
                    return true;

                case R.id.buildingCondition:
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, buildingFragment).commit();
                    return true;

                case R.id.tips:
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, tipsFragment).commit();
                    return true;

                case R.id.dontdo:
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, dontDoFragment).commit();
                    return true;
            }
            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.buildingCondition);
    }



}