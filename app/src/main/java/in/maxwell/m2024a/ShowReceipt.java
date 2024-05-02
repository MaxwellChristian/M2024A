package in.maxwell.m2024a;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowReceipt extends AppCompatActivity {

    TextView tvPaidAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_receipt);

        tvPaidAmount = findViewById(R.id.tvPaidAmount);

        Bundle receivedBundle = getIntent().getExtras();
        // String paidAmount = receivedBundle.getString("key_paid_amount");
        String paidAmount = receivedBundle.getString(getResources().getString(R.string.key_amount));

        tvPaidAmount.setText(paidAmount);

    }
}