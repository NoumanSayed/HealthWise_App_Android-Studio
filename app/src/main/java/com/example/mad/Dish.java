package com.example.mad;

import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {
    private String name;
    private double caloriesPerUnit;
    private double protein;
    private double fat;
    private double carbs;
    private String unit;

    public Dish(String name, double caloriesPerUnit, double protein, double fat, double carbs, String unit) {
        this.name = name;
        this.caloriesPerUnit = caloriesPerUnit;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.unit = unit;
    }

    protected Dish(Parcel in) {
        name = in.readString();
        caloriesPerUnit = in.readDouble();
        protein = in.readDouble();
        fat = in.readDouble();
        carbs = in.readDouble();
        unit = in.readString();
    }

    public static final Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };

    public String getName() {
        return name;
    }

    public double getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(caloriesPerUnit);
        dest.writeDouble(protein);
        dest.writeDouble(fat);
        dest.writeDouble(carbs);
        dest.writeString(unit);
    }
}
