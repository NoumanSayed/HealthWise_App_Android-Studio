package com.example.mad;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderItem implements Parcelable {
    private Dish dish;
    private double quantity;
    private double itemCalories;
    private double itemProtein;
    private double itemFat;
    private double itemCarbs;

    public OrderItem(Dish dish, double quantity, double itemCalories, double itemProtein, double itemFat, double itemCarbs) {
        this.dish = dish;
        this.quantity = quantity;
        this.itemCalories = itemCalories;
        this.itemProtein = itemProtein;
        this.itemFat = itemFat;
        this.itemCarbs = itemCarbs;
    }

    protected OrderItem(Parcel in) {
        dish = in.readParcelable(Dish.class.getClassLoader());
        quantity = in.readDouble();
        itemCalories = in.readDouble();
        itemProtein = in.readDouble();
        itemFat = in.readDouble();
        itemCarbs = in.readDouble();
    }

    public static final Creator<OrderItem> CREATOR = new Creator<OrderItem>() {
        @Override
        public OrderItem createFromParcel(Parcel in) {
            return new OrderItem(in);
        }

        @Override
        public OrderItem[] newArray(int size) {
            return new OrderItem[size];
        }
    };

    public Dish getDish() {
        return dish;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getItemCalories() {
        return itemCalories;
    }

    public double getItemProtein() {
        return itemProtein;
    }

    public double getItemFat() {
        return itemFat;
    }

    public double getItemCarbs() {
        return itemCarbs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(dish, flags);
        dest.writeDouble(quantity);
        dest.writeDouble(itemCalories);
        dest.writeDouble(itemProtein);
        dest.writeDouble(itemFat);
        dest.writeDouble(itemCarbs);
    }
}
