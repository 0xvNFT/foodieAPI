package com.checkgiathucpham.jayson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.checkgiathucpham.jayson.adapter.FoodContentAdapter;

public class FoodContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_content);

        GridView gridView = findViewById(R.id.grid_view);

        int[] imageIds = {
                R.drawable.food_content2,
                R.drawable.food_content3,
                R.drawable.food_content4,
                R.drawable.food_content5,
                R.drawable.food_content6,
                R.drawable.food_content7
        };

        FoodContentAdapter adapter = new FoodContentAdapter(imageIds);
        gridView.setAdapter(adapter);

        ImageView mainFoodContentImageView = findViewById(R.id.main_food_content);
        mainFoodContentImageView.setOnClickListener(v -> {
            Intent intent = new Intent(FoodContentActivity.this, FoodDishActivity.class);
            startActivity(intent);
        });
    }

}