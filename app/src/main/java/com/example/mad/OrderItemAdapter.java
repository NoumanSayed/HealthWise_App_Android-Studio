package com.example.mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderItemViewHolder> {

    private Context context;
    private List<OrderItem> orderList;

    public OrderItemAdapter(Context context, List<OrderItem> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_layout, parent, false);
        return new OrderItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemViewHolder holder, int position) {
        // Get the data for the current item
        OrderItem orderItem = orderList.get(position);
        Dish dish = orderItem.getDish();

        // Bind the data to the views in the ViewHolder
        holder.dishNameTextView.setText(dish.getName());
        holder.quantityTextView.setText(String.format(Locale.getDefault(), "Quantity: %.2f %s", orderItem.getQuantity(), dish.getUnit()));
        holder.caloriesTextView.setText(String.format(Locale.getDefault(), "Calories: %.2f", orderItem.getItemCalories()));
        holder.proteinTextView.setText(String.format(Locale.getDefault(), "Protein: %.2f g", orderItem.getItemProtein()));
        holder.fatTextView.setText(String.format(Locale.getDefault(), "Fat: %.2f g", orderItem.getItemFat()));
        holder.carbsTextView.setText(String.format(Locale.getDefault(), "Carbs: %.2f g", orderItem.getItemCarbs()));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderItemViewHolder extends RecyclerView.ViewHolder {
        TextView dishNameTextView;
        TextView quantityTextView;
        TextView caloriesTextView;
        TextView proteinTextView;
        TextView fatTextView;
        TextView carbsTextView;

        public OrderItemViewHolder(@NonNull View itemView) {
            super(itemView);
            dishNameTextView = itemView.findViewById(R.id.dishNameTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            caloriesTextView = itemView.findViewById(R.id.caloriesTextView);
            proteinTextView = itemView.findViewById(R.id.proteinTextView);
            fatTextView = itemView.findViewById(R.id.fatTextView);
            carbsTextView = itemView.findViewById(R.id.carbsTextView);
        }
    }
}

