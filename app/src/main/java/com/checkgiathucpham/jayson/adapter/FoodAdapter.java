package com.checkgiathucpham.jayson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.checkgiathucpham.jayson.R;
import com.checkgiathucpham.jayson.model.FoodItem;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private final Context context;
    private final List<FoodItem> foodItems;

    public FoodAdapter(Context context, List<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int position) {
        return foodItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
            holder = new ViewHolder();
            holder.nameTextView = convertView.findViewById(R.id.column_name);
            holder.priceTextView = convertView.findViewById(R.id.column_price);
            holder.quantityTextView = convertView.findViewById(R.id.column_quantity);
            holder.descriptionTextView = convertView.findViewById(R.id.column_description);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FoodItem foodItem = foodItems.get(position);

        holder.nameTextView.setText(foodItem.getName());
        holder.priceTextView.setText(foodItem.getPrice());
        holder.quantityTextView.setText(foodItem.getQuantity());
        holder.descriptionTextView.setText(foodItem.getDescription());

        return convertView;
    }

    private static class ViewHolder {
        TextView nameTextView;
        TextView priceTextView;
        TextView quantityTextView;
        TextView descriptionTextView;
    }
}

