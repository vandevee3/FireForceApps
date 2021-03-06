package com.example.fireforceapps;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FiremanInformation extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mapAPI;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fireman_information);



        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;

        LatLng PemadamKebakaranSurabaya = new LatLng(-7.322177758112991, 112.71372000897117);

        mapAPI.addMarker(new MarkerOptions().position(PemadamKebakaranSurabaya).title("Damkar"));

        mapAPI.moveCamera(CameraUpdateFactory.newLatLngZoom(PemadamKebakaranSurabaya, 10));


    }

    public void onClickBuilding(View view) {
        Intent intent = new Intent(FiremanInformation.this, BuildingCondition.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickTips(View view) {
        Intent intent = new Intent(FiremanInformation.this, Tips.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickDontDo(View view) {
        Intent intent = new Intent(FiremanInformation.this, DontDo.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}