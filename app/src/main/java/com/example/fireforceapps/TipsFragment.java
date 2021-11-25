package com.example.fireforceapps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class TipsFragment extends Fragment {

    public TipsFragment(){
        // require a empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tips, container, false);
    }
}