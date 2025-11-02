package com.example.personalbudgettracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailInput = findViewById(R.id.email_input);
        EditText passwordInput = findViewById(R.id.password_input);
        Button loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(v -> {
            // For prototype, skip authentication
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        });
    }
}
