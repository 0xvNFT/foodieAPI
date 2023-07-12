package com.checkgiathucpham.jayson.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodDish implements Parcelable {
    public static final Creator<FoodDish> CREATOR = new Creator<FoodDish>() {
        @Override
        public FoodDish createFromParcel(Parcel in) {
            return new FoodDish(in);
        }

        @Override
        public FoodDish[] newArray(int size) {
            return new FoodDish[size];
        }
    };
    private final String name;
    private final int imageResId;
    private final String description;

    public FoodDish(String name, int imageResId, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
    }

    protected FoodDish(Parcel in) {
        name = in.readString();
        imageResId = in.readInt();
        description = in.readString();
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResId);
        dest.writeString(description);
    }

    public int getImageId() {
        return imageResId;
    }
}
