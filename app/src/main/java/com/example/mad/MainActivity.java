package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBMI, btnCalorie;
    LinearLayout mainContent;
    LinearLayout loadingView;
    ImageView userInfoIcon;

    private String userName;
    private String userAge;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContent = findViewById(R.id.mainContent);
        loadingView = findViewById(R.id.loadingView);
        btnBMI = findViewById(R.id.btnBMI);
        btnCalorie = findViewById(R.id.btnCalorie);
        userInfoIcon = findViewById(R.id.userInfoIcon);

        // Initially show loading screen
        showLoadingScreen();

        // Retrieve user info from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("userName");
            userAge = extras.getString("userAge");
            userEmail = extras.getString("userEmail");
        }

        // Simulate loading data (replace with your actual loading logic)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadingScreen();

                // Set up button click listeners after loading is complete
                btnBMI.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, BmiActivity.class));
                    }
                });

                btnCalorie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, CalorieActivity.class));
                    }
                });
            }
        }, 2000); // Simulate 2 seconds of loading

        // Set OnClickListener for the user info icon to open UserInfoActivity
        userInfoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "User Info Icon Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("userAge", userAge);
                intent.putExtra("userEmail", userEmail);
                startActivity(intent);
            }
        });
    }

    private void showLoadingScreen() {
        mainContent.setVisibility(View.GONE);
        userInfoIcon.setVisibility(View.GONE); // Hide icon during loading
        loadingView.setVisibility(View.VISIBLE);
    }

    private void hideLoadingScreen() {
        loadingView.setVisibility(View.GONE);
        mainContent.setVisibility(View.VISIBLE);
        userInfoIcon.setVisibility(View.VISIBLE); // Show icon after loading
    }
}