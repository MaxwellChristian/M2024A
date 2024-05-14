package in.maxwell.m2024a;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentExamples extends AppCompatActivity {

    TextView tvContactNumber;
    Button btnCall;
    Button btnDial;
    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intent_examples);

        tvContactNumber = findViewById(R.id.tvContactNumber);
        btnCall = findViewById(R.id.btnCall);
        btnDial = findViewById(R.id.btnDial);
        btnAlert = findViewById(R.id.btnShowDialog);

        btnDial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + tvContactNumber.getText().toString()));
            startActivity(intent);
        });

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + tvContactNumber.getText().toString()));
            startActivity(intent);
        });

        btnAlert.setOnClickListener(v -> {

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            // alertDialog.setCancelable(false);

            alertDialog.setTitle("Confirm");
            alertDialog.setMessage("Do you want to call?");

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", (dialog, which) -> {
                Toast.makeText(IntentExamples.this, "You clicked: Yes", Toast.LENGTH_SHORT).show();
            });

            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", (dialog, which) -> {
                Toast.makeText(IntentExamples.this, "You clicked: No", Toast.LENGTH_SHORT).show();
            });

            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel", (dialog, which) -> {
                Toast.makeText(IntentExamples.this, "You clicked: Cancel", Toast.LENGTH_SHORT).show();
            });

            alertDialog.show();
        });

    }
}