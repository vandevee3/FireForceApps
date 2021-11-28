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

    Button lantai4; // 4th floor
    Button lantai3; // 3rd floor
    Button lantai2; // 2nd floor
    Button lantai1; // 1st floor
    Button G; // Ground floor
    Button UG; // Under Ground floor

    Boolean isSafe = true;
    Boolean empatFloorClick = false;
    Boolean tigaFloorClick = false;
    Boolean duaFloorClick = false;
    Boolean satuFloorClick = false;
    Boolean gFloor = false;
    Boolean UGFloor = false;

    private int [] mImages = new int []{
            R.drawable.ic_warning_information__1_,R.drawable.ic_safe_information__1_
    };

    private String [] mLantaiEmpatList = new String[]{
            "Main Rooom", "Hall", "Meeting Room"
    };

    private String [] mLantaiTigaList = new String[]{
            "Main Room", "Work Space", "Library"
    };

    private String [] mLantaiDuaList = new String[]{
            "Main Room", "Laboratory A", "Laboratory B"
    };

    private String [] mLantaiSatuList = new String[]{
            "Reception Room"
    };

    private String [] mLantaiG = new String []{
            "Food Terace", "Parking Area"
    };

    private String [] mLantaiUG = new String[]{
            "Parking Area"
    };

    public BuildingConditionFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_building_condition, container, false);
        CarouselView carousel1 = (CarouselView) view.findViewById(R.id.carousel);

        lantai4 = view.findViewById(R.id.button7);
        lantai3 = view.findViewById(R.id.button8);
        lantai2 = view.findViewById(R.id.button9);
        lantai1 = view.findViewById(R.id.button11);
        G = view.findViewById(R.id.button12);
        UG = view.findViewById(R.id.button13);
        carousel1.setPageCount(mLantaiEmpatList.length);

        lantai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lantai4.setBackground(getResources().getDrawable(R.color.blue));
                carousel1.setPageCount(mLantaiEmpatList.length);
                tigaFloorClick = false;
                duaFloorClick = false;
                satuFloorClick = false;
                gFloor = false;
                UGFloor = false;
                empatFloorClick = true;
            }
        });

        lantai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lantai3.setBackground(getResources().getDrawable(R.color.blue));
                carousel1.setPageCount(mLantaiTigaList.length);
                empatFloorClick = false;
                duaFloorClick = false;
                satuFloorClick = false;
                gFloor = false;
                UGFloor = false;
                tigaFloorClick = true;
            }
        });

        lantai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lantai2.setBackground(getResources().getDrawable(R.color.blue));
                carousel1.setPageCount(mLantaiDuaList.length);
                empatFloorClick = false;
                tigaFloorClick = false;
                satuFloorClick = false;
                gFloor = false;
                UGFloor = false;
                duaFloorClick = true;
            }
        });

        lantai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lantai1.setBackground(getResources().getDrawable(R.color.blue));
                carousel1.setPageCount(mLantaiSatuList.length);
                empatFloorClick = false;
                tigaFloorClick = false;
                duaFloorClick = false;
                gFloor = false;
                UGFloor = false;
                satuFloorClick = true;
            }
        });

        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G.setBackground(getResources().getDrawable(R.color.blue));
                carousel1.setPageCount(mLantaiG.length);
                empatFloorClick = false;
                tigaFloorClick = false;
                duaFloorClick = false;
                satuFloorClick = false;
                UGFloor = false;
                gFloor = true;
            }
        });

        UG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UG.setBackground(getResources().getDrawable(R.color.blue));
                carousel1.setPageCount(mLantaiUG.length);
                empatFloorClick = false;
                tigaFloorClick = false;
                duaFloorClick = false;
                satuFloorClick = false;
                gFloor = false;
                UGFloor = true;
            }
        });


//        carousel1.setImageListener((position, imageView) -> imageView.setImageResource(mImages[position]));
//        carousel1.setImageClickListener(position -> Toast.makeText(getActivity(), mImagesTitle[position], Toast.LENGTH_SHORT).show());
        carousel1.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View vView = getLayoutInflater().inflate(R.layout.custom_carousel, null);
                ImageView image = (ImageView) vView.findViewById(R.id.carouselImage);
                TextView title = (TextView) vView.findViewById(R.id.carouselText);

                if (empatFloorClick){
                    title.setText(mLantaiEmpatList[position]);
                } else if (tigaFloorClick){
                    title.setText(mLantaiTigaList[position]);
                } else if (duaFloorClick){
                    title.setText(mLantaiDuaList[position]);
                } else if (satuFloorClick){
                    title.setText(mLantaiSatuList[position]);
                } else if (gFloor) {
                    title.setText(mLantaiG[position]);
                } else if (UGFloor){
                    title.setText(mLantaiUG[position]);
                }

                if (!isSafe){
                    image.setImageResource(mImages[0]);
                }else {
                    image.setImageResource(mImages[1]);
                }

                return vView;
            }
        });
        return view;
    }
}