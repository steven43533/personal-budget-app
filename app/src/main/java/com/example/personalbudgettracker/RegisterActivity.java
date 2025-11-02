package com.example.personalbudgettracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button createBtn = findViewById(R.id.btnCreate);
        createBtn.setOnClickListener(v -> {
            // Skip actual registration for prototype
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        });
    }
}
