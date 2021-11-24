package com.example.fireforceapps;


import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

public class BuildingCondition extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        FiremanInformationFragment firemanFragment = new FiremanInformationFragment();
        BuildingConditionFragment buildingFragment = new BuildingConditionFragment();
        TipsFragment tipsFragment = new TipsFragment();

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
            }
            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.buildingCondition);

    }



}