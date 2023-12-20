package ru.siurgtu.gymapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.siurgtu.gymapp.R;

public class ExerciseCatalogActivity extends AppCompatActivity {

    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_catalog);
        setInitialData();
        RecyclerView catalog = findViewById(R.id.catalog);
        ExerciseAdapter adapter = new ExerciseAdapter(this, exercises);
        catalog.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }
    private void setInitialData(){

        exercises.add(new Exercise ("Отжимания", "От пола", R.drawable.pushups));
        exercises.add(new Exercise ("Приседания", "На ноги", R.drawable.squat));
        exercises.add(new Exercise ("Скручивания", "На полу", R.drawable.flexions));
        exercises.add(new Exercise ("Подтягивания", "К турнику", R.drawable.pullup));
        exercises.add(new Exercise ("Планка", "Долгая", R.drawable.plank));
    }
}