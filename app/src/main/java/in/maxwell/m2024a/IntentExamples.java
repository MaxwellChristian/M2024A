package in.maxwell.m2024a;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
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
    Button btnShowLinkedIn;

    ImageView ivShowOnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intent_examples);

        tvContactNumber = findViewById(R.id.tvContactNumber);
        btnCall = findViewById(R.id.btnCall);
        btnDial = findViewById(R.id.btnDial);
        btnAlert = findViewById(R.id.btnShowDialog);
        btnShowLinkedIn = findViewById(R.id.btnLinkedIn);

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

        btnShowLinkedIn.setOnClickListener(v -> {
            String url = "http://www.linked.com";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        ivShowOnMap = findViewById(R.id.ivShowOnMap);
        ivShowOnMap.setOnClickListener(v -> {

//            Uri.Builder builder = new Uri.Builder();
//            builder.scheme("https")
//                    .authority("www.google.com")
//                    .appendPath("maps")
//                    .appendPath("dir")
//                    .appendPath("")
//                    .appendQueryParameter("api", "1")
//                    .appendQueryParameter("destination", 50.4254761 + "," + -104.610385);
//            String url = builder.build().toString();
//            Log.d("Directions", url);
//            Intent i = new Intent(Intent.ACTION_VIEW);
//            i.setData(Uri.parse(url));
//            startActivity(i);

            // display map for a particular coordinate with a zoom level and a custom label
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?z=17&q=50.4273269,-104.6142173( SLT )"));
            // in the above code, 'z' signifies the zoom level (0-21, o for world view and 21 for buildings)
            // int the above coe, 'q' signifies the search query
            // in the above code, '( SLT )' is the custom label

            // search for all restaurants
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?z=15&q=restaurants"));

            // search for a particular coordinate and label it (as MLT)
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?z=15&q=50.4273269,-104.6142173(MLT)"));

            // set the zoom level (0: world view, 21: buildings)
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.4273269,-104.6142173?z=17"));

            // Searches for 'Play Park' near given coordinates
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.4273269,-104.6142173?q=Play+Park"));

            mapIntent.setPackage("com.google.android.apps.maps");

            startActivity(mapIntent);
        });


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