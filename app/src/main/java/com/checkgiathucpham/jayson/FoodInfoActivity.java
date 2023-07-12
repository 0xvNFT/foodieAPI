package com.checkgiathucpham.jayson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.checkgiathucpham.jayson.model.FoodDish;
import com.google.gson.Gson;

public class FoodInfoActivity extends AppCompatActivity {

    private TextView dishNameTextView;
    private TextView dishDescriptionTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        dishNameTextView = findViewById(R.id.dish_name);
        dishDescriptionTextView = findViewById(R.id.dish_description);
        Button favoriteButton = findViewById(R.id.button_fav);
        Intent intent = getIntent();
        FoodDish foodDish = null;
        if (intent != null && intent.hasExtra("food_dish")) {
            foodDish = intent.getParcelableExtra("food_dish");
            if (foodDish != null) {
                dishNameTextView.setText(foodDish.getName());
                dishDescriptionTextView.setText(foodDish.getDescription());
            }
        }

        final FoodDish finalFoodDish = foodDish;
        FoodDish finalFoodDish1 = foodDish;
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the selected FoodDish object to SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(finalFoodDish1.getName(), new Gson().toJson(finalFoodDish1));
                editor.apply();

                Toast.makeText(FoodInfoActivity.this, "Added to Favorites", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addFavoriteItem(FoodDish foodDish) {
        SharedPreferences sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jsonFoodDish = new Gson().toJson(foodDish);
        editor.putString(foodDish.getName(), jsonFoodDish);
        editor.apply();
    }

}

