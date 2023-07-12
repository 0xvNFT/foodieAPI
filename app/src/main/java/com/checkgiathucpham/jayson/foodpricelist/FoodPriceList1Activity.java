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

public class FoodPriceList1Activity extends AppCompatActivity {

    private TextView dateTextView;
    private TableLayout tableLayout;
    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_price_list1);

        dateTextView = findViewById(R.id.date_text_view);
        String currentDate = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.getDefault()).format(new Date());
        dateTextView.setText(currentDate);

        tableLayout = findViewById(R.id.table_layout);

        addRowToTable("1", "Bắp Cải Tím", "$10", "KG");
        addRowToTable("2", "Bắp Cải Trắng", "$15", "KG");
        addRowToTable("3", "Cải Chíp", "$8", "KG");
        addRowToTable("4", "Cải Dưa", "$12", "KG");
        addRowToTable("5", "Cải Ngọt", "$20", "KG");
        addRowToTable("6", "Cải Ngồng", "$5", "KG");
        addRowToTable("7", "Cải Thảo", "$10", "KG");
        addRowToTable("8", "Cải Thìa", "$15", "KG");
        addRowToTable("9", "Cải Xoong", "$8", "KG");
        addRowToTable("10", "Cần Tàu", "$12", "KG");
        addRowToTable("12", "Cần Tây", "$20", "KG");
        addRowToTable("13", "Đậu Cove", "$20", "KG");
        addRowToTable("14", "Đậu Bắp", "$20", "KG");
        addRowToTable("15", "Đậu Hà Lan Tươi", "$20", "KG");
        addRowToTable("16", "Đậu Rồng", "$20", "KG");
        addRowToTable("17", "Đu Đủ Xanh", "$20", "KG");
        addRowToTable("18", "Mồng Tơi", "$20", "KG");
        addRowToTable("19", "Mướp Hương", "$20", "KG");
        addRowToTable("20", "Mướp Rừng", "$20", "KG");
        addRowToTable("21", "Nấm Bào Ngư", "$20", "KG");
        addRowToTable("22", "Đậu Bắp", "$20", "KG");
        addRowToTable("23", "Bắp chuối", "$20", "KG");
        addRowToTable("24", "Chanh", "$20", "KG");
        addRowToTable("25", "Ớt sừng", "$20", "KG");
        addRowToTable("26", "Me vắt", "$20", "KG");
        addRowToTable("27", "Bắp Cải Tím", "$10", "KG");
        addRowToTable("28", "Bắp Cải Trắng", "$15", "KG");
        addRowToTable("29", "Cải Chíp", "$8", "KG");
        addRowToTable("30", "Cải Dưa", "$12", "KG");
        addRowToTable("31", "Cải Ngọt", "$20", "KG");
        addRowToTable("32", "Cải Ngồng", "$5", "KG");
        addRowToTable("33", "Cải Thảo", "$10", "KG");
        addRowToTable("34", "Cải Thìa", "$15", "KG");
        addRowToTable("35", "Cải Xoong", "$8", "KG");
        addRowToTable("36", "Bắp Cải Tím", "$10", "KG");
        addRowToTable("37", "Bắp Cải Trắng", "$15", "KG");
        addRowToTable("38", "Cải Chíp", "$8", "KG");
        addRowToTable("39", "Cải Dưa", "$12", "KG");
        addRowToTable("40", "Cải Ngọt", "$20", "KG");
        addRowToTable("41", "Cải Ngồng", "$5", "KG");
        addRowToTable("42", "Cải Thảo", "$10", "KG");
        addRowToTable("43", "Cải Thìa", "$15", "KG");
        addRowToTable("44", "Cải Xoong", "$8", "KG");
        addRowToTable("45", "Bắp Cải Tím", "$10", "KG");
        addRowToTable("46", "Bắp Cải Trắng", "$15", "KG");
        addRowToTable("47", "Cải Chíp", "$8", "KG");
        addRowToTable("48", "Cải Dưa", "$12", "KG");
        addRowToTable("49", "Cải Ngọt", "$20", "KG");
        addRowToTable("50", "Cải Ngồng", "$5", "KG");


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