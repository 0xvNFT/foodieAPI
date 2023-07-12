package com.checkgiathucpham.jayson.foodpricelist;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.checkgiathucpham.jayson.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FoodPriceList3Activity extends AppCompatActivity {

    private TextView dateTextView;
    private TableLayout tableLayout;
    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_price_list3);

        dateTextView = findViewById(R.id.date_text_view);
        String currentDate = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.getDefault()).format(new Date());
        dateTextView.setText(currentDate);

        tableLayout = findViewById(R.id.table_layout);

        addRowToTable("1", "Bắp Cải Tím", "$10", "KG");
        addRowToTable("2", "Bắp Cải Trắng", "$15", "KG");
        addRowToTable("3", "Cải Chíp", "$8", "KG");


        scrollView = findViewById((R.id.scroll_view));
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }

    private void addRowToTable(String stt, String name, String price, String unit) {
        TableRow row = new TableRow(this);

        TextView sttTextView = new TextView(this);
        sttTextView.setText(stt);
        row.addView(sttTextView);

        TextView nameTextView = new TextView(this);
        nameTextView.setText(name);
        row.addView(nameTextView);

        TextView unitTextView = new TextView(this);
        unitTextView.setText(unit);
        row.addView(unitTextView);

        TextView priceTextView = new TextView(this);
        priceTextView.setText(price);
        row.addView(priceTextView);

        tableLayout.addView(row);
    }
}