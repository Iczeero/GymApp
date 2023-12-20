package ru.siurgtu.gymapp;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Exercise> exercises;

        ExerciseAdapter(Context context, List<Exercise> exercises) {
        this.exercises = exercises;
        this.inflater = LayoutInflater.from(context);
        }
@Override
public ExerciseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.exercise, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(ExerciseAdapter.ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
    if (exercise != null) {
        holder.flagView.setImageResource(exercise.getImgResource());
        holder.nameView.setText(exercise.getName());
        holder.capitalView.setText(exercise.getDiscription());
    } else {
        Log.e("ExerciseAdapter", "Exercise at position " + position + " is null");
    }
        }

@Override
public int getItemCount() {
        return exercises.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView flagView;
    final TextView nameView, capitalView;
    ViewHolder(View view){
        super(view);
        flagView = view.findViewById(R.id.img);
        nameView = view.findViewById(R.id.name);
        capitalView = view.findViewById(R.id.discription);
    }
}
}
