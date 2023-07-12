package com.checkgiathucpham.jayson;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ImageView deliciousImageView = findViewById(R.id.delicious);
        deliciousImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodContentActivity.class);
            startActivity(intent);
        });
        ImageView cookingImageView = findViewById(R.id.cooking);
        cookingImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodPriceActivity.class);
            startActivity(intent);
        });

        ImageView openDrawerButton = findViewById(R.id.hamburger_white);

        openDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item1) {
            Intent intent = new Intent(this, FavoriteActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else if (itemId == R.id.menu_item2) {
            Toast.makeText(this, "Giới thiệu", Toast.LENGTH_SHORT).show();
            openWebPage("https://www.google.com/");
        } else if (itemId == R.id.menu_item3) {
            Toast.makeText(this, "Chính sách", Toast.LENGTH_SHORT).show();
            openWebPage("https://www.google.com/");
        } else if (itemId == R.id.menu_item4) {
            Intent intent = new Intent(this, SupportActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        return false;
    }

    public void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}


