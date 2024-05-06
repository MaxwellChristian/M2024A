package in.maxwell.m2024a;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ColorMixer extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sbRed;
    SeekBar sbGreen;
    SeekBar sbBlue;

    TextView tvRedValue;
    TextView tvGreenValue;
    TextView tvBlueValue;

    int redPart;
    int greenPart;
    int bluePart;

    TextView tvColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_color_mixer);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        tvRedValue = findViewById(R.id.tvRedValue);
        tvGreenValue = findViewById(R.id.tvGreenValue);
        tvBlueValue = findViewById(R.id.tvBlueValue);

        tvColor = findViewById(R.id.tvColor);

        sbRed.setOnSeekBarChangeListener(ColorMixer.this);
        sbGreen.setOnSeekBarChangeListener(ColorMixer.this);
        sbBlue.setOnSeekBarChangeListener(ColorMixer.this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar.getId() == R.id.sbRed) {
            redPart = progress;
            tvRedValue.setText(progress + "");
        }

        if (seekBar.getId() == R.id.sbGreen) {
            greenPart = progress;
            tvGreenValue.setText(progress + "");
        }

        if (seekBar.getId() == R.id.sbBlue) {
            bluePart = progress;
            tvBlueValue.setText(progress + "");
        }

        int mixedColor = Color.rgb(redPart, greenPart, bluePart);
        tvColor.setBackgroundColor(mixedColor);

        // 136 181 178

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}