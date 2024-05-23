package in.maxwell.m2024a;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DateTimePicker extends AppCompatActivity {

    Button btnShowDate;
    Button btnShowTime;

    TextView tvNotificationTitle;
    TextView tvNotificationText = null;
    private String notificationTitle = null;
    private String notificationText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        if( bundle != null ){
            notificationTitle = bundle.getString("notificationTitle");
            notificationText = bundle.getString("notificationText");

            Log.d("DateTimePicker", "notificationTitle: " + notificationTitle);
            Log.d("DateTimePicker", "notificationText: " + notificationText);
        }

        setContentView(R.layout.activity_date_time_picker);

        btnShowDate = findViewById(R.id.btnShowDate);
        btnShowTime = findViewById(R.id.btnShowTime);

        tvNotificationTitle = findViewById(R.id.tvNotificationTitle);
        tvNotificationText = findViewById(R.id.tvNotificationText);

        if( notificationTitle != null ){
            tvNotificationTitle.setText(notificationTitle);
            tvNotificationTitle.setVisibility(View.VISIBLE);
        }
        if( notificationText != null ){
            tvNotificationText.setText(notificationText);
            tvNotificationText.setVisibility(View.VISIBLE);
        }

        btnShowDate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimePicker.this);
            datePickerDialog.setOnDateSetListener((view, year, month, dayOfMonth) -> {
                // Handle the selected date here
                Log.d("DateTimePicker", "Selected date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
            });
            datePickerDialog.show();
        });

        btnShowTime.setOnClickListener(v -> {
            // Handle the button click here

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    this,
                    (view, hourOfDay, minute) -> {},
                    9, 40,
                    true);

            timePickerDialog.show();

        });
    }
}