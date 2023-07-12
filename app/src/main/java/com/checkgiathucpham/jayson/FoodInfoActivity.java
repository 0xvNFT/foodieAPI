package com.checkgiathucpham.jayson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.checkgiathucpham.jayson.model.FoodDish;

public class FoodInfoActivity extends AppCompatActivity {

    private TextView dishNameTextView;
    private TextView dishDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        dishNameTextView = findViewById(R.id.dish_name);
        dishDescriptionTextView = findViewById(R.id.dish_description);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("food_dish")) {
            FoodDish foodDish = intent.getParcelableExtra("food_dish");
            if (foodDish != null) {
                dishNameTextView.setText(foodDish.getName());
                dishDescriptionTextView.setText(foodDish.getDescription());
            }
        }
    }
}

