package com.example.mad;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import java.util.Locale;

public class BmiActivity extends AppCompatActivity {

    private TextInputLayout weightInputLayout;
    private TextInputEditText weightEditText;
    private TextInputLayout heightInputLayout;
    private TextInputEditText heightEditText;
    private MaterialButton calculateButton;
    private MaterialTextView resultTextView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_bmi);

        weightInputLayout = findViewById(R.id.weightInputLayout);
        weightEditText = findViewById(R.id.weight);
        heightInputLayout = findViewById(R.id.heightInputLayout);
        heightEditText = findViewById(R.id.height);
        calculateButton = findViewById(R.id.btnSubmit);
        resultTextView = findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightInput = weightEditText.getText().toString().trim();
        String heightInput = heightEditText.getText().toString().trim();

        if (weightInput.isEmpty()) {
            weightInputLayout.setError(getString(R.string.error_weight_required));
            return;
        } else {
            weightInputLayout.setError(null);
        }

        if (heightInput.isEmpty()) {
            heightInputLayout.setError(getString(R.string.error_height_required));
            return;
        } else {
            heightInputLayout.setError(null);
        }

        try {
            float weight = Float.parseFloat(weightInput); // in kg
            float heightCm = Float.parseFloat(heightInput); // in cm
            float heightMeters = heightCm / 100; // convert to meters

            if (heightMeters <= 0 || weight <= 0) {
                Toast.makeText(this, R.string.error_positive_values, Toast.LENGTH_SHORT).show();
                return;
            }

            float bmi = weight / (heightMeters * heightMeters);
            String category = getBMICategory(bmi);

            String result = String.format(Locale.getDefault(), "%s: %.2f\n%s: %s",
                    getString(R.string.your_bmi), bmi, getString(R.string.category), category);
            resultTextView.setText(result);

            // Clear the input fields after calculation
            weightEditText.setText("");
            heightEditText.setText("");

        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.error_invalid_input, Toast.LENGTH_SHORT).show();
        }
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) return getString(R.string.underweight);
        else if (bmi < 24.9) return getString(R.string.normal_weight);
        else if (bmi < 29.9) return getString(R.string.overweight);
        else return getString(R.string.obesity);
    }
}