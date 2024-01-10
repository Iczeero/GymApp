package ru.siurgtu.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Button backButton = findViewById(R.id.button3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseCatalogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setInitialData(){

        exercises.add(new Exercise ("Отжимания", "Упражнение развивает силу и выносливость грудных мышц, трехглавой мышцы плеча и трицепса. В упоре лёжа поднимайте и опускайте тело с помощью рук.", R.drawable.pushups, "pushups"));
        exercises.add(new Exercise ("Приседания", "Приседания отлично развивают силу и выносливость ягодичных мышц, квадрицепса и бицепса бедра. Становитесь прямо, опускайтесь, сгибая колени, как будто садитесь на стул, затем поднимайтесь обратно в исходное положение.", R.drawable.squat, "squats"));
        exercises.add(new Exercise ("Скручивания", "Упражнение направлено на укрепление мышц живота и является эффективным способом разработки пресса. Лежа на спине, поднимайте плечи и верхнюю часть тела, сгибая их к коленям.", R.drawable.flexions, "flexions"));
        exercises.add(new Exercise ("Подтягивания", "Упражнение, развивающее группы мышц верхней части тела: широчайшая, бицепс, брахиалис, предплечья. Выполняется в висе. Представляет собой поднятие и опускание тела с помощью рук.", R.drawable.pullup, "pullups"));
        exercises.add(new Exercise ("Планка", "Статическое упражнение, которое задействует множество мышц, включая мышцы спины, плеч и ног. Встаньте в упор лёжа, но держите тело на прямых руках или локтях", R.drawable.plank, "plank"));
    }
}