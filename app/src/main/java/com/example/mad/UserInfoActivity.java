package com.example.mad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    private TextView userNameDisplay;
    private TextView userAgeDisplay;
    private TextView userEmailDisplay;
    private Button btnCloseProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userNameDisplay = findViewById(R.id.userNameDisplay);
        userAgeDisplay = findViewById(R.id.userAgeDisplay);
        userEmailDisplay = findViewById(R.id.userEmailDisplay);
        btnCloseProfile = findViewById(R.id.btnCloseProfile);

        // Retrieve user info from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String userName = extras.getString("userName");
            String userAge = extras.getString("userAge");
            String userEmail = extras.getString("userEmail");

            userNameDisplay.setText(getString(R.string.name_placeholder) + userName);
            userAgeDisplay.setText(getString(R.string.age_placeholder) + userAge);
            userEmailDisplay.setText(getString(R.string.email_placeholder) + userEmail);
        }

        // Set OnClickListener for the Close button
        btnCloseProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous one (MainActivity)
                finish();
            }
        });
    }
}