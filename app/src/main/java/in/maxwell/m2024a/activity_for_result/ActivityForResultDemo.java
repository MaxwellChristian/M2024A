package in.maxwell.m2024a.activity_for_result;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import in.maxwell.m2024a.R;

public class ActivityForResultDemo extends AppCompatActivity {

    Button btnSelectImage;
    ImageView imgSelectedImage;

    ActivityResultLauncher<String> getContentLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
        if (uri != null) {
            // Do something with the selected image URI
            Log.d("Image URI", "Selected image URI: " + uri.toString());
            Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();

            imgSelectedImage.setImageURI(uri);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_for_result_demo);

        imgSelectedImage = findViewById(R.id.imgSelectedImage);

        ActivityResultLauncher<String> activityLauncher = registerForActivityResult(new MyActivityContract(), result -> {
            // Handle the result here
            Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
        });

        btnSelectImage = findViewById(R.id.btnSelectImage);
        btnSelectImage.setOnClickListener(v -> {
            getContentLauncher.launch("image/*");

            //activityLauncher.launch(null);


        });
    }
}