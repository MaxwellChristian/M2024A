package in.maxwell.m2024a;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

            String permission = Manifest.permission.CALL_PHONE;
            boolean granted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;

            if (!granted) {
                requestPermissions(new String[]{permission}, 1234);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + tvContactNumber.getText().toString()));
                startActivity(intent);
            }

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

        String url = "www.linked.com";

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d("Permissions", "onRequestPermissionsResult: Permission Granted");

        } else {
            Log.d("Permissions", "onRequestPermissionsResult: Permission NOT Granted");
        }

    }
}