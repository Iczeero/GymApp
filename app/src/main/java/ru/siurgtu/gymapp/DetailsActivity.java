package ru.siurgtu.gymapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, ExerciseCatalogActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String itemDiscription = intent.getStringExtra("item_discription");
            String itemName = intent.getStringExtra("item_name");
            int itemImg = intent.getIntExtra("image_resource", R.drawable.pushups);
            String videoResource = intent.getStringExtra("video_resource");

            TextView textViewName = findViewById(R.id.item_name);
            TextView textViewDiscription = findViewById(R.id.item_discription);
            ImageView itemImgRes = findViewById(R.id.item_img);
            VideoView videoView = findViewById(R.id.item_video);

            itemImgRes.setImageResource(itemImg);

            String videoPath = "android.resource://" + getPackageName() + "/raw/" + videoResource;
            videoView.setVideoURI(Uri.parse(videoPath));
            videoView.start();

            textViewName.setText(itemName);
            textViewDiscription.setText(itemDiscription);

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoView.seekTo(0);
                    videoView.start();
                }
            });

            videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoView.isPlaying()) {
                        videoView.pause();
                    }
                    else {
                        videoView.start();
                    }
                }
            });
        }



    }
}
