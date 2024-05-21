package in.maxwell.m2024a.video_demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import in.maxwell.m2024a.R;

public class VideDemoActivity extends AppCompatActivity {

    Button btnShowVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vide_demo);

        btnShowVideo = findViewById(R.id.btnPlayVideo);
        btnShowVideo.setOnClickListener(v -> {

            Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/paw_ITMrf-E?feature=shared"));
            startActivity(videoIntent);

//            Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.saskpolytech.ca"));
//            startActivity(videoIntent);

//            Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Saskatchewan+Polytechnic,+Regina+Campus/@50.4077084,-104.5819046,17z/data=!3m1!4b1!4m6!3m5!1s0x531ea0f2ce2cf2fb:0xde9358ab42a882b0!8m2!3d50.4077084!4d-104.5819046!16s%2Fg%2F1jlk05yx3?entry=ttu"));
//            startActivity(videoIntent);


        });




    }
}