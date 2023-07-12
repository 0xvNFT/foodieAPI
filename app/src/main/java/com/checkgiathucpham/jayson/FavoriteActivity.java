package com.checkgiathucpham.jayson;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.checkgiathucpham.jayson.adapter.FoodContentAdapter;
import com.checkgiathucpham.jayson.model.FoodDish;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FavoriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        loadFavoriteItems();
    }

    private void loadFavoriteItems() {
        SharedPreferences sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE);
        Map<String, ?> allItems = sharedPreferences.getAll();

        List<FoodDish> favoriteItems = new ArrayList<>();
        for (Map.Entry<String, ?> entry : allItems.entrySet()) {
            String jsonFoodDish = entry.getValue().toString();
            FoodDish foodDish = new Gson().fromJson(jsonFoodDish, FoodDish.class);
            favoriteItems.add(foodDish);
        }

        int[] imageIds = new int[favoriteItems.size()];
        for (int i = 0; i < favoriteItems.size(); i++) {
            imageIds[i] = favoriteItems.get(i).getImageId();
        }

        ListView listView = findViewById(R.id.list_view_fav);
        FoodContentAdapter adapter = new FoodContentAdapter(this, imageIds);
        listView.setAdapter(adapter);
    }


}
