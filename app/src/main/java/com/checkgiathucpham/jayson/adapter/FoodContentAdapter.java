package com.checkgiathucpham.jayson.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.checkgiathucpham.jayson.R;

public class FoodContentAdapter extends BaseAdapter {
    private final int[] imageIds;

    public FoodContentAdapter(int[] imageIds) {
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

        return view;
    }
}

