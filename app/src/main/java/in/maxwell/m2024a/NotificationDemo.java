package in.maxwell.m2024a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificationDemo extends AppCompatActivity {

    private static final int MY_APP_NOTIFICATION_ID = 1122;
    private static final String MY_APP_NOTIFICATION_CHANNEL_ID = "MY_APP_NOTIFICATION_CHANNEL_ID";
    private static final String MY_APP_NOTIFICATION_CHANNEL_NAME = "MY_APP_NOTIFICATION_CHANNEL_NAME";
    Button btnShowNotification;

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notification_demo);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnShowNotification = findViewById(R.id.btnShowNotification);
        btnShowNotification.setOnClickListener(v -> {
            showNotification();
        });

    }

    private void showNotification() {

        Intent nextIntent = new Intent(NotificationDemo.this, DateTimePicker.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationDemo.this, 0, nextIntent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationDemo.this, MY_APP_NOTIFICATION_CHANNEL_ID);
        // builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder
                .setSmallIcon(androidx.appcompat.R.drawable.abc_star_black_48dp)
                .setContentTitle("My App Notification")
                .setContentText("The test content for the custom notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationChannel notificationChannel = new NotificationChannel(MY_APP_NOTIFICATION_CHANNEL_ID, MY_APP_NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel);

        notificationManager.notify(MY_APP_NOTIFICATION_ID, builder.build());

    }
}