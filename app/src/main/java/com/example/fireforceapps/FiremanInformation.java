package com.example.fireforceapps;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FiremanInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fireman_information);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.red)));
    }
}