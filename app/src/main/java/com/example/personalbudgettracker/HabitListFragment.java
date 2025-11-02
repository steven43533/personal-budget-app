package com.example.personalbudgettracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitListFragment extends Fragment {

    private RecyclerView recyclerView;
    private HabitAdapter adapter;
    private List<HabitManager.HabitItem> habits; // <-- List of HabitItem

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_habit_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewHabits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        habits = HabitManager.getInstance().getHabits(); // <-- returns List<HabitItem>
        adapter = new HabitAdapter(habits);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {

        private final List<HabitManager.HabitItem> habits;

        HabitAdapter(List<HabitManager.HabitItem> habits) {
            this.habits = habits;
        }

        @NonNull
        @Override
        public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_habit, parent, false);
            return new HabitViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
            HabitManager.HabitItem habit = habits.get(position);
            holder.name.setText(habit.name);
            holder.streak.setText("Streak: " + habit.streak);

            holder.completeBtn.setOnClickListener(v -> {
                habit.streak++;
                notifyItemChanged(position);
                Toast.makeText(getContext(),
                        habit.name + " completed! Streak: " + habit.streak,
                        Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return habits.size();
        }

        class HabitViewHolder extends RecyclerView.ViewHolder {
            TextView name, streak;
            Button completeBtn;

            HabitViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.habitName);
                streak = itemView.findViewById(R.id.habitStreak);
                completeBtn = itemView.findViewById(R.id.completeBtn);
            }
        }
    }
}
