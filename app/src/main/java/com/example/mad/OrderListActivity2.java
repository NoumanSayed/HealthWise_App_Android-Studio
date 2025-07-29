package com.example.mad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class OrderListActivity2 extends AppCompatActivity {

    private RecyclerView orderItemList;
    private OrderItemAdapter orderItemAdapter;
    private ArrayList<OrderItem> orderList; // Change to ArrayList
    private TextView totalTextView;
    private double totalCalories;
    private double totalProtein;
    private double totalFat;
    private double totalCarbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list2); // This line links the XML layout

        // Initialize UI elements
        orderItemList = findViewById(R.id.orderItemList);
        totalTextView = findViewById(R.id.totalTextView);

        // Get the order list from the intent
        orderList =  getIntent().getParcelableArrayListExtra("orderList");

        // Initialize totals
        totalCalories = 0;
        totalProtein = 0;
        totalFat = 0;
        totalCarbs = 0;

        // Calculate totals
        if (orderList != null) {
            for (OrderItem item : orderList) {
                totalCalories += item.getItemCalories();
                totalProtein += item.getItemProtein();
                totalFat += item.getItemFat();
                totalCarbs += item.getItemCarbs();
            }
        }


        // Set up the RecyclerView
        orderItemList.setLayoutManager(new LinearLayoutManager(this));
        orderItemAdapter = new OrderItemAdapter(this, orderList);
        orderItemList.setAdapter(orderItemAdapter);

        // Display the total
        String resultText = String.format(Locale.getDefault(),
                "Total Calories: %.2f\nTotal Protein: %.2f g\nTotal Fat: %.2f g\nTotal Carbs: %.2f g",
                totalCalories, totalProtein, totalFat, totalCarbs);
        totalTextView.setText(resultText);
    }
}