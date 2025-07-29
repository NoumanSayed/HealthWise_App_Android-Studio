package com.example.mad;



import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;

import android.view.View;

import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;



import com.google.android.material.button.MaterialButton;

import com.google.android.material.imageview.ShapeableImageView;

import com.google.android.material.textfield.TextInputEditText;

import com.google.android.material.textfield.TextInputLayout;

import com.google.android.material.textview.MaterialTextView;



public class LoginActivity extends AppCompatActivity {



    private static final int SPLASH_TIME_OUT = 4000; // Time in milliseconds



    private ShapeableImageView splashLogo;

    private MaterialTextView splashName;

    private MaterialTextView welcomeText;

    private TextInputLayout nameTextInputLayout;

    private TextInputEditText editTextName;

    private TextInputLayout ageTextInputLayout;

    private TextInputEditText editTextAge;

    private TextInputLayout emailTextInputLayout;

    private TextInputEditText editTextEmail;

    private MaterialButton buttonLogin;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);



        splashLogo = findViewById(R.id.splashLogo);

        splashName = findViewById(R.id.splashName);

        welcomeText = findViewById(R.id.welcomeText);

        nameTextInputLayout = findViewById(R.id.nameTextInputLayout);

        editTextName = findViewById(R.id.editTextName);

        ageTextInputLayout = findViewById(R.id.ageTextInputLayout);

        editTextAge = findViewById(R.id.editTextAge);

        emailTextInputLayout = findViewById(R.id.emailTextInputLayout);

        editTextEmail = findViewById(R.id.editTextEmail);

        buttonLogin = findViewById(R.id.buttonLogin);



// Initially hide the login fields and welcome text (already done in XML)

        welcomeText.setVisibility(View.GONE);

        nameTextInputLayout.setVisibility(View.GONE);

        ageTextInputLayout.setVisibility(View.GONE);

        emailTextInputLayout.setVisibility(View.GONE);

        buttonLogin.setVisibility(View.GONE);



        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

// Fade out splash elements (optional)

                splashLogo.setVisibility(View.GONE);

                splashName.setVisibility(View.GONE);



// Make login elements and welcome text visible

                welcomeText.setVisibility(View.VISIBLE);

                nameTextInputLayout.setVisibility(View.VISIBLE);

                ageTextInputLayout.setVisibility(View.VISIBLE);

                emailTextInputLayout.setVisibility(View.VISIBLE);

                buttonLogin.setVisibility(View.VISIBLE);

            }

        }, SPLASH_TIME_OUT);



        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();

                String ageStr = editTextAge.getText().toString().trim();

                String email = editTextEmail.getText().toString().trim();



// Basic validation (you can add more robust checks)

                if (name.isEmpty()) {

                    nameTextInputLayout.setError(getString(R.string.error_name_required));

                    return;

                } else {

                    nameTextInputLayout.setError(null); // Clear error

                }



                if (ageStr.isEmpty()) {

                    ageTextInputLayout.setError(getString(R.string.error_age_required));

                    return;

                }



                int age;

                try {

                    age = Integer.parseInt(ageStr);

                    if (age <= 0 || age > 150) {

                        ageTextInputLayout.setError(getString(R.string.error_invalid_age));

                        return;

                    } else {

                        ageTextInputLayout.setError(null); // Clear error

                    }

                } catch (NumberFormatException e) {

                    ageTextInputLayout.setError(getString(R.string.error_invalid_age_format));

                    return;

                }



                if (email.isEmpty()) {

                    emailTextInputLayout.setError(getString(R.string.error_email_required));

                    return;

                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    emailTextInputLayout.setError(getString(R.string.error_invalid_email));

                    return;

                } else {

                    emailTextInputLayout.setError(null); // Clear error

                }



// If validation passes, navigate to MainActivity and pass user info

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                intent.putExtra("userName", name);

                intent.putExtra("userAge", ageStr);

                intent.putExtra("userEmail", email);

                startActivity(intent);

                finish(); // Optional: Close LoginActivity

            }

        });

    }

}