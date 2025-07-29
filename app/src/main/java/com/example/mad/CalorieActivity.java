package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalorieActivity extends AppCompatActivity {

    private Spinner dishSpinner;
    private EditText quantityEditText;
    private Button addButton;
    private TextView resultTextView;
    private List<Dish> dishList;
    private ArrayAdapter<String> dishNameAdapter;
    private ArrayList<OrderItem> orderList; // Change to ArrayList
    private double totalCalories;
    private double totalProtein;
    private double totalFat;
    private double totalCarbs;
    private Button viewOrderButton; // Added Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        // Initialize UI elements
        dishSpinner = findViewById(R.id.dishSpinner);
        quantityEditText = findViewById(R.id.quantityEditText);
        addButton = findViewById(R.id.addButton);
        resultTextView = findViewById(R.id.resultTextView);
        viewOrderButton = findViewById(R.id.viewOrderButton); // Find the new button

        // Initialize the dish list
        dishList = DishData.getAllDishes();

        // Populate the spinner with dish names
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : dishList) {
            dishNames.add(dish.getName());
        }
        dishNameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dishNames);
        dishNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dishSpinner.setAdapter(dishNameAdapter);

        // Initialize the order list and totals
        orderList = new ArrayList<>(); // Initialize as ArrayList
        totalCalories = 0;
        totalProtein = 0;
        totalFat = 0;
        totalCarbs = 0;

        // Set click listener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToOrder();
            }
        });

        // Set click listener for the view order button
        viewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderListActivity
                Intent intent = new Intent(CalorieActivity.this, OrderListActivity2.class);
                intent.putExtra("orderList",  orderList); // Pass the order list
                startActivity(intent);
            }
        });

        // Optional: Set a listener for the spinner item selection
        dishSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // You can add any specific logic here if needed when a dish is selected.
                // For example, you could update a unit label next to the quantity input.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case where nothing is selected (optional)
            }
        });
    }

    private void addItemToOrder() {
        try {
            // Get the selected dish name
            String selectedDishName = dishSpinner.getSelectedItem().toString();
            // Get the entered quantity
            String quantityStr = quantityEditText.getText().toString().trim();

            // Validate quantity input
            if (quantityStr.isEmpty()) {
                Toast.makeText(this, "Please enter a quantity", Toast.LENGTH_SHORT).show();
                return;
            }
            double quantity = Double.parseDouble(quantityStr);

            // Find the selected dish in the dishList
            Dish selectedDish = null;
            for (Dish dish : dishList) {
                if (dish.getName().equals(selectedDishName)) {
                    selectedDish = dish;
                    break;
                }
            }

            // Check if the dish was found
            if (selectedDish == null) {
                Toast.makeText(this, "Dish not found", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate the calories and macros for this item
            double itemCalories = selectedDish.getCaloriesPerUnit() * quantity;
            double itemProtein = selectedDish.getProtein() * quantity;
            double itemFat = selectedDish.getFat() * quantity;
            double itemCarbs = selectedDish.getCarbs() * quantity;

            // Add the item to the order list
            OrderItem orderItem = new OrderItem(selectedDish, quantity, itemCalories, itemProtein, itemFat, itemCarbs);
            orderList.add(orderItem);
            totalCalories += itemCalories;
            totalProtein += itemProtein;
            totalFat += itemFat;
            totalCarbs += itemCarbs;

            // Display the updated total
            String resultText = String.format(Locale.US,
                    "Total Calories: %.2f\nTotal Protein: %.2f g\nTotal Fat: %.2f g\nTotal Carbs: %.2f g",
                    totalCalories, totalProtein, totalFat, totalCarbs);
            resultTextView.setText(resultText);

            // Clear the quantity input for the next item
            quantityEditText.getText().clear();

            Toast.makeText(this, "Item added to order", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            // Handle invalid quantity input
            Toast.makeText(this, "Invalid quantity format. Please enter a number.", Toast.LENGTH_SHORT).show();
            quantityEditText.setText("");
        }
    }
}