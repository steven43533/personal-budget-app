package com.example.personalbudgettracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddHabitActivity extends AppCompatActivity {

    private EditText habitNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        habitNameInput = findViewById(R.id.habitNameInput);
        Button saveHabitBtn = findViewById(R.id.saveHabitBtn);

        saveHabitBtn.setOnClickListener(v -> {
            String habitName = habitNameInput.getText().toString().trim();
            if (!habitName.isEmpty()) {
                // Add a new HabitItem to HabitManager
                HabitManager.HabitItem habit = new HabitManager.HabitItem(habitName, 0);
                HabitManager.getInstance().addHabit(habit);

                Toast.makeText(this, "Habit added!", Toast.LENGTH_SHORT).show();
                finish(); // close activity
            } else {
                Toast.makeText(this, "Enter a habit name", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
