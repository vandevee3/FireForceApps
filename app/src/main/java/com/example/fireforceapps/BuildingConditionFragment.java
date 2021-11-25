package com.example.fireforceapps;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BuildingConditionFragment extends Fragment {

    private int [] mImages = new int []{
            R.drawable.ic_warning_information__1_,R.drawable.ic_safe_information__1_
    };

    private String [] mImagesTitle = new String[]{
            "Warning Information", "Safe Information"
    };

    public BuildingConditionFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_building_condition, container, false);
        CarouselView carousel1 = (CarouselView) view.findViewById(R.id.carousel);
        carousel1.setPageCount(mImages.length);
        carousel1.setImageListener((position, imageView) -> imageView.setImageResource(mImages[position]));
        carousel1.setImageClickListener(position -> Toast.makeText(getActivity(), mImagesTitle[position], Toast.LENGTH_SHORT).show());
        return inflater.inflate(R.layout.activity_building_condition, container, false);
    }
}