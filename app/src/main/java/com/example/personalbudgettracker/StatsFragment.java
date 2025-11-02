package com.example.personalbudgettracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StatsFragment extends Fragment {

    private RecyclerView recyclerView;
    private HabitAdapter adapter;
    private List<HabitManager.HabitItem> habits;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewStats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        habits = HabitManager.getInstance().getHabits();

        adapter = new HabitAdapter(habits);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    // Adapter for RecyclerView
    private static class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {

        private final List<HabitManager.HabitItem> habits;

        HabitAdapter(List<HabitManager.HabitItem> habits) {
            this.habits = habits;
        }

        @NonNull
        @Override
        public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_stat, parent, false);
            return new HabitViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
            HabitManager.HabitItem habit = habits.get(position);
            holder.name.setText(habit.name);
            holder.streak.setText("Streak: " + habit.streak);
        }

        @Override
        public int getItemCount() {
            return habits.size();
        }

        static class HabitViewHolder extends RecyclerView.ViewHolder {
            TextView name, streak;

            HabitViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.statName);
                streak = itemView.findViewById(R.id.statStreak);
            }
        }
    }
}
