package com.checkgiathucpham.jayson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.checkgiathucpham.jayson.R;
import com.checkgiathucpham.jayson.model.FoodDish;

import java.util.ArrayList;
import java.util.List;

public class FoodDishAdapter extends BaseAdapter implements Filterable {

    private final List<FoodDish> dishList;
    private final Context context;
    private List<FoodDish> filteredList;
    private DishFilter dishFilter;

    public FoodDishAdapter(Context context, List<FoodDish> dishList) {
        this.context = context;
        this.dishList = dishList;
        this.filteredList = dishList;
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_food_dish, parent, false);
            holder = new ViewHolder();
            holder.foodDishImageView = convertView.findViewById(R.id.food_dish);
            holder.foodDishNameTextView = convertView.findViewById(R.id.food_dish_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FoodDish dish = filteredList.get(position);

        holder.foodDishImageView.setImageResource(dish.getImageResId());
        holder.foodDishNameTextView.setText(dish.getName());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (dishFilter == null) {
            dishFilter = new DishFilter();
        }
        return dishFilter;
    }

    private static class ViewHolder {
        ImageView foodDishImageView;
        TextView foodDishNameTextView;
    }

    private class DishFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0) {

                results.count = dishList.size();
                results.values = dishList;
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                List<FoodDish> filteredDishes = new ArrayList<>();

                for (FoodDish dish : dishList) {
                    if (dish.getName().toLowerCase().contains(filterPattern)) {
                        filteredDishes.add(dish);
                    }
                }

                results.count = filteredDishes.size();
                results.values = filteredDishes;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (List<FoodDish>) results.values;
            notifyDataSetChanged();
        }
    }
}

