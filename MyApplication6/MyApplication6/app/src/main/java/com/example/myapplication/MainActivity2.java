package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText emailAddress; // Added this variable for the email input
    private EditText passcodeTxt;
    private ImageView showHidePassIcon;
    private boolean isPasswordVisible = false;
    private Button login; // Changed to Button since it's a Button in the layout


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Initialize the EditTexts, ImageView, and Button
        emailAddress = findViewById(R.id.EmailAddressTxt);
        passcodeTxt = findViewById(R.id.passcodetxt);
        showHidePassIcon = findViewById(R.id.showHidePassIcon);
        login = findViewById(R.id.LogInButton);

        // Set the initial input type to password
        passcodeTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        // Set up click listener to toggle password visibility
        showHidePassIcon.setOnClickListener(v -> {
            if (isPasswordVisible) {
                // Hide Password
                passcodeTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                showHidePassIcon.setImageResource(R.drawable.ic_showpass);  // Update icon
            } else {
                // Show Password
                passcodeTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                showHidePassIcon.setImageResource(R.drawable.hide_pass);  // Update icon
            }
            // Move the cursor to the end of the text
            passcodeTxt.setSelection(passcodeTxt.length());
            isPasswordVisible = !isPasswordVisible;
        });

        // Set up the login button click listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddress.getText().toString();
                String password = passcodeTxt.getText().toString();

                if (email.equals("Admin") && password.equals("admin123")) {
                    Toast.makeText(MainActivity2.this, "Login successful", Toast.LENGTH_SHORT).show();

                    // Create an Intent to start the DashboardActivity
                    Intent intent = new Intent(MainActivity2.this,DashBoard.class);
                    startActivity(intent);
                    finish(); // Optionally, call finish() if you want to close the login activity
                } else {
                    Toast.makeText(MainActivity2.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
