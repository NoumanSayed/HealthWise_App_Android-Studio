package com.example.mad;

import java.util.ArrayList;
import java.util.List;

public class DishData {
    public static List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Apple", 52, 0.3, 0.2, 14, "per 100 grams"));
        dishes.add(new Dish("Chicken Breast (cooked)", 165, 31, 3.6, 0, "per 100 grams"));
        dishes.add(new Dish("Rice (cooked)", 130, 2.7, 0.3, 28, "per 100 grams"));
        dishes.add(new Dish("Egg, whole (cooked)", 155, 13, 11, 1.1, "per 100 grams"));
        dishes.add(new Dish("Milk, whole", 60, 3.2, 3.3, 4.8, "per 100 ml"));
        dishes.add(new Dish("Bread, white", 266, 9, 3.2, 49, "per 100 grams"));
        dishes.add(new Dish("Pasta, cooked", 158, 5.5, 1, 30, "per 100 grams"));
        dishes.add(new Dish("Salmon, cooked", 208, 20, 13, 0, "per 100 grams"));
        dishes.add(new Dish("Potato, baked", 93, 2.5, 0.1, 21, "per 100 grams"));
        dishes.add(new Dish("Broccoli, cooked", 55, 3.7, 0.6, 10, "per 100 grams"));
        dishes.add(new Dish("Carrot, raw", 41, 0.9, 0.2, 9.6, "per 100 grams"));
        dishes.add(new Dish("Orange", 47, 1, 0.1, 12, "per 100 grams"));
        dishes.add(new Dish("Banana", 89, 1.1, 0.3, 23, "per 100 grams"));
        dishes.add(new Dish("Avocado", 160, 2, 15, 9, "per 100 grams"));
        dishes.add(new Dish("Cheese, cheddar", 403, 25, 33, 2.5, "per 100 grams"));
        dishes.add(new Dish("Pizza, cheese", 266, 11, 10, 33, "per 100 grams"));
        dishes.add(new Dish("Burger, beef", 295, 15, 9.5, 39, "per 1 burger"));
        dishes.add(new Dish("Fries, french", 312, 3.4, 15, 41, "per 100 grams"));
        dishes.add(new Dish("Coke", 42, 0, 0, 10.6, "per 100 ml"));
        dishes.add(new Dish("Water", 0, 0, 0, 0, "per 100 ml"));

        // Add more dishes here
        dishes.add(new Dish("Biryani, chicken", 250, 10, 8, 30, "per 100 grams"));
        dishes.add(new Dish("Bread, brown", 247, 8, 3, 48, "per 100 grams"));
        dishes.add(new Dish("Butter", 717, 0.9, 81, 0.1, "per 100 grams"));
        dishes.add(new Dish("Chicken Curry", 215, 20, 13, 8, "per 100 grams"));
        dishes.add(new Dish("Dal Makhani", 280, 8, 15, 25, "per 100 grams"));
        dishes.add(new Dish("Fish Curry", 175, 22, 8, 5, "per 100 grams"));
        dishes.add(new Dish("Gulab Jamun", 300, 2, 10, 45, "per piece"));
        dishes.add(new Dish("Ice Cream", 207, 4, 11, 24, "per 100 grams"));
        dishes.add(new Dish("Juice, orange", 45, 0.7, 0.2, 11.8, "per 100 ml"));
        dishes.add(new Dish("Kheer", 150, 4, 5, 20, "per 100 grams"));
        dishes.add(new Dish("Lassi", 60, 3.5, 4, 5, "per 100 ml"));
        dishes.add(new Dish("Naan", 260, 7, 5, 48, "per 100 grams"));
        dishes.add(new Dish("Paneer Tikka", 294, 18, 20, 6, "per 100 grams"));
        dishes.add(new Dish("Samosa", 252, 5, 15, 25, "per piece"));
        dishes.add(new Dish("Tea, with milk", 50, 2, 2, 6, "per 100 ml"));
        dishes.add(new Dish("Coffee, with milk", 60, 2, 3, 8, "per 100ml"));
        dishes.add(new Dish("Chapati", 100, 3, 0.5, 20, "per piece"));
        dishes.add(new Dish("Dosa", 160, 4, 6, 25, "per piece"));
        dishes.add(new Dish("Idli", 40, 2, 0.5, 8, "per piece"));
        dishes.add(new Dish("Vada", 80, 2, 5, 10, "per piece"));
        dishes.add(new Dish("Poha", 250, 4, 12, 30, "per 100 grams"));
        dishes.add(new Dish("Upma", 200, 5, 8, 25, "per 100 grams"));
        dishes.add(new Dish("Paratha", 200, 6, 9, 28, "per piece"));
        dishes.add(new Dish("Chole Bhature", 450, 10, 20, 60, "per serving"));
        dishes.add(new Dish("Aloo Tikki", 150, 2, 8, 18, "per piece"));
        dishes.add(new Dish("Pav Bhaji", 380, 8, 20, 45, "per serving"));
        dishes.add(new Dish("Masala Dosa", 300, 6, 10, 40, "per piece"));
        dishes.add(new Dish("Roti", 70, 2, 0.4, 15, "per piece"));
        dishes.add(new Dish("Dal", 120, 7, 0.5, 20, "per 100 grams"));
        dishes.add(new Dish("Rajma", 130, 8, 0.5, 22, "per 100 grams"));
        dishes.add(new Dish("Palak Paneer", 200, 7, 12, 8, "per 100 grams"));
        dishes.add(new Dish("Mutter Paneer", 180, 6, 10, 10, "per 100 grams"));
        dishes.add(new Dish("Shahi Paneer", 250, 10, 18, 12, "per 100 grams"));
        dishes.add(new Dish("Chana Masala", 150, 5, 6, 22, "per 100 grams"));
        dishes.add(new Dish("Bhindi Masala", 100, 2, 6, 8, "per 100 grams"));
        dishes.add(new Dish("Aloo Gobi", 80, 2, 4, 10, "per 100 grams"));
        dishes.add(new Dish("Baingan Bharta", 90, 1.5, 5, 12, "per 100 grams"));
        dishes.add(new Dish("Mushroom Curry", 120, 3, 8, 15, "per 100 grams"));
        dishes.add(new Dish("Paneer Butter Masala", 300, 12, 20, 15, "per 100 grams"));
        dishes.add(new Dish("Malai Kofta", 280, 8, 18, 20, "per 100 grams"));
        dishes.add(new Dish("Vegetable Biryani", 200, 6, 7, 30, "per 100 grams"));
        dishes.add(new Dish("Pulao", 180, 5, 6, 25, "per 100 grams"));
        dishes.add(new Dish("Fried Rice", 200, 6, 8, 28, "per 100 grams"));
        dishes.add(new Dish("Hakka Noodles", 220, 7, 10, 30, "per 100 grams"));
        dishes.add(new Dish("Manchurian", 250, 8, 12, 35, "per 100 grams"));
        dishes.add(new Dish("Spring Roll", 180, 3, 8, 22, "per piece"));
        dishes.add(new Dish("Szechuan Chicken", 280, 25, 18, 10, "per 100 grams"));
        dishes.add(new Dish("Chili Chicken", 260, 20, 15, 12, "per 100 grams"));
        dishes.add(new Dish("Chicken Manchurian", 270, 22, 16, 14, "per 100 grams"));
        dishes.add(new Dish("Mutton Curry", 250, 23, 15, 7, "per 100 grams"));
        dishes.add(new Dish("Fish Fry", 200, 25, 10, 0, "per 100 grams"));
        dishes.add(new Dish("Prawn Curry", 180, 18, 8, 6, "per 100 grams"));
        dishes.add(new Dish("Egg Curry", 150, 12, 9, 3, "per 100 grams"));
        dishes.add(new Dish("Chicken Biryani", 300, 12, 10, 40, "per 100 grams"));
        dishes.add(new Dish("Mutton Biryani", 350, 15, 12, 45, "per 100 grams"));
        dishes.add(new Dish("Hyderabadi Biryani", 320, 13, 11, 42, "per 100 grams"));
        dishes.add(new Dish("Veg Biryani", 280, 8, 9, 38, "per 100 grams"));
        return dishes;
    }
}

