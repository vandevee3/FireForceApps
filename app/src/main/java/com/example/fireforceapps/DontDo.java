package com.example.fireforceapps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DontDo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_do);

        getSupportActionBar().hide();
    }
}