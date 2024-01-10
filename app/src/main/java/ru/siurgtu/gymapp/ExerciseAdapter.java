package ru.siurgtu.gymapp;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Exercise> exercises;

    private Context context;

        ExerciseAdapter(Context context, List<Exercise> exercises) {
        this.exercises = exercises;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        }
@Override
public ExerciseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.exercise, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(ExerciseAdapter.ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);

        holder.flagView.setImageResource(exercise.getImgResource());
        holder.nameView.setText(exercise.getName());
        //holder.capitalView.setText(exercise.getDiscription());
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("item_name", exercise.getName());
                intent.putExtra("item_discription", exercise.getDiscription());
                intent.putExtra("image_resource", exercise.getImgResource());
                intent.putExtra("video_resource", exercise.getVideoResource());
                context.startActivity(intent);
            }
        });
        }

@Override
public int getItemCount() {
        return exercises.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView flagView;
    final TextView nameView/*, capitalView*/;
    final Button addButton;
    ViewHolder(View view){
        super(view);
        flagView = view.findViewById(R.id.img);
        nameView = view.findViewById(R.id.name);
        //capitalView = view.findViewById(R.id.discription);
        addButton = view.findViewById(R.id.addButton);
    }
}
}
