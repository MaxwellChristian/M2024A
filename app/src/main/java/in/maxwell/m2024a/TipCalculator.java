package in.maxwell.m2024a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TipCalculator extends AppCompatActivity {

    EditText etPrice;
    EditText etTax;
    EditText etTip;

    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tip_calculator);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // bind the controls
        etPrice = findViewById(R.id.etPrice);
        etTax = findViewById(R.id.etTax);
        etTip = findViewById(R.id.etTip);

        btnCalculate = findViewById(R.id.btnCalculate);

        // attach the listener and respond to the event
        btnCalculate.setOnClickListener(v -> {

        });

    }
}