package com.example.fireforceapps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.synnapps.carouselview.CarouselView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BuildingConditionFragment extends Fragment {

    public BuildingConditionFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_building_condition, container, false);
        CarouselView carousel1 = (CarouselView) view.findViewById(R.id.carousel);
        return view;

    }
}