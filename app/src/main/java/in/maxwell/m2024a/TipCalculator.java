package in.maxwell.m2024a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    TextView tvPayableAmount;
    Button btnShowReceipt;

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

        tvPayableAmount = findViewById(R.id.tvTotalPayable);

        // attach the listener and respond to the event
        btnCalculate.setOnClickListener(v -> {

            double total = Double.parseDouble(etPrice.getText().toString())
                    + Double.parseDouble(etTax.getText().toString())
                    + Double.parseDouble(etTip.getText().toString())
                    ;

            tvPayableAmount.setText("" + total );
        });

        btnShowReceipt = findViewById(R.id.btnShowReceipt);
        btnShowReceipt.setOnClickListener(v -> {

            Intent intentReceipt = new Intent(TipCalculator.this, ShowReceipt.class) ;

            // intentReceipt.putExtra("key_paid_amount", tvPayableAmount.getText().toString());
            intentReceipt.putExtra(getResources().getString(R.string.key_amount), tvPayableAmount.getText().toString());

            startActivity(intentReceipt);

            // use the below code if you do not want the back to this activity
            // TipCalculator.this.finish();

        });

    }
}