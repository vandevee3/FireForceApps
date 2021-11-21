package com.example.fireforceapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), BuildingCondition.class));
    }

    public void onClick2(View view) {
        startActivity(new Intent(getApplicationContext(), Tips.class));
    }

    public void onClick3(View view) {
        startActivity(new Intent(getApplicationContext(), DontDo.class));
    }

    public void onClick5(View view){
        startActivity(new Intent(getApplicationContext(), FiremanInformation.class));
    }


}