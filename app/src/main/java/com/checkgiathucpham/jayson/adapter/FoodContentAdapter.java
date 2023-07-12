package com.checkgiathucpham.jayson.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.checkgiathucpham.jayson.R;
import com.checkgiathucpham.jayson.fooddish.FoodDish2Activity;
import com.checkgiathucpham.jayson.fooddish.FoodDish3Activity;
import com.checkgiathucpham.jayson.fooddish.FoodDish4Activity;
import com.checkgiathucpham.jayson.fooddish.FoodDish5Activity;
import com.checkgiathucpham.jayson.fooddish.FoodDish6Activity;
import com.checkgiathucpham.jayson.fooddish.FoodDish7Activity;

public class FoodContentAdapter extends BaseAdapter {
    private final Context context;
    private final int[] imageIds;

    public FoodContentAdapter(Context context, int[] imageIds) {
        this.context = context;
        this.imageIds = imageIds;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_content, parent, false);

        ImageView imageView = view.findViewById(R.id.image_view);
        TextView titleTextView = view.findViewById(R.id.title_text_view);

        imageView.setImageResource(imageIds[position]);
        titleTextView.setText("Food Item " + (position + 1));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(context, FoodDish2Activity.class);
                        context.startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, FoodDish3Activity.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, FoodDish4Activity.class);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, FoodDish5Activity.class);
                        context.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(context, FoodDish6Activity.class);
                        context.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(context, FoodDish7Activity.class);
                        context.startActivity(intent5);
                        break;

                }
            }
        });

        return view;
    }
}

