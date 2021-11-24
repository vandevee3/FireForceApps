package com.example.fireforceapps;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class BuildingCondition extends AppCompatActivity {

    private int[] mImages = new int[]{
      R.drawable.ic_safe_information__1_, R.drawable.ic_warning_information__1_
    };

    private String[] mImagesTitle = new String[]{
      "Safe Information", "Warning Infomration"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_condition);

        getSupportActionBar().hide();

        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            private int position;

            @Override
            public void onClick(int position) {
                this.position = position;
                Toast.makeText(BuildingCondition.this, "",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClickFireman(View view) {
        Intent intent = new Intent(BuildingCondition.this, FiremanInformation.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickTips(View view) {
        Intent intent = new Intent(BuildingCondition.this, Tips.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickDontDo(View view) {
        Intent intent = new Intent(BuildingCondition.this, DontDo.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}