package com.checkgiathucpham.jayson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.checkgiathucpham.jayson.foodpricelist.FoodPriceList1Activity;
import com.checkgiathucpham.jayson.foodpricelist.FoodPriceList2Activity;
import com.checkgiathucpham.jayson.foodpricelist.FoodPriceList3Activity;

public class FoodPriceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_price);

        ImageView food_price1 = findViewById(R.id.food_price1);
        ImageView food_price2 = findViewById(R.id.food_price2);
        ImageView food_price3 = findViewById(R.id.food_price3);

        food_price1.setImageResource(R.drawable.food_price1);
        food_price2.setImageResource(R.drawable.food_price2);
        food_price3.setImageResource(R.drawable.food_price3);

        food_price1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodPriceActivity.this, FoodPriceList1Activity.class);
                startActivity(intent);
            }
        });
        food_price2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodPriceActivity.this, FoodPriceList2Activity.class);
                startActivity(intent);
            }
        });
        food_price3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodPriceActivity.this, FoodPriceList3Activity.class);
                startActivity(intent);
            }
        });
    }
}
