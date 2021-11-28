package com.example.fireforceapps;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BuildingConditionFragment extends Fragment {

    Button button7;

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
//        carousel1.setImageListener((position, imageView) -> imageView.setImageResource(mImages[position]));
//        carousel1.setImageClickListener(position -> Toast.makeText(getActivity(), mImagesTitle[position], Toast.LENGTH_SHORT).show());
        carousel1.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View vView = getLayoutInflater().inflate(R.layout.custom_carousel, null);
                ImageView image = (ImageView) vView.findViewById(R.id.carouselImage);
                TextView title = (TextView) vView.findViewById(R.id.carouselText);

                title.setText(mImagesTitle[position]);
                image.setImageResource(mImages[position]);

                return vView;
            }
        });
        final boolean[] state = {false};
        button7 = view.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!state[0]){
                    button7.setBackgroundColor(getResources().getColor(R.color.red));
                    state[0] = true;
                }else{
                    button7.setBackgroundColor(getResources().getColor(R.color.gray1));
                    state[0] = false;
                }
            }
        });


        return view;
    }
}