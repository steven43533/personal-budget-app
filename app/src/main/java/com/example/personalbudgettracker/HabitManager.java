package com.example.personalbudgettracker;

import java.util.ArrayList;
import java.util.List;

public class HabitManager {

    private static HabitManager instance;
    private final List<HabitItem> habits;

    private HabitManager() {
        habits = new ArrayList<>();
        // Dummy habits
        habits.add(new HabitItem("Drink Water", 2));
        habits.add(new HabitItem("Exercise", 0));
    }

    public static synchronized HabitManager getInstance() {
        if (instance == null) {
            instance = new HabitManager();
        }
        return instance;
    }

    public List<HabitItem> getHabits() {
        return habits;
    }

    public void addHabit(HabitItem habit) {
        habits.add(habit);
    }

    public static class HabitItem {
        public String name;
        public int streak;

        public HabitItem(String name, int streak) {
            this.name = name;
            this.streak = streak;
        }
    }
}
