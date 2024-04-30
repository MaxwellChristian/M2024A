package in.maxwell.m2024a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // create controls
        EditText etMessage;
        Button btnShow;
        TextView tvMessage;

        // bind the controls
        etMessage = findViewById(R.id.etMessage);
        btnShow = findViewById(R.id.btnShowMessage);
        tvMessage = findViewById(R.id.tvMessage);

        // add listeners
        btnShow.setOnClickListener(v -> {
            tvMessage.setText(etMessage.getText());
        });

        // respond to events

    }
}