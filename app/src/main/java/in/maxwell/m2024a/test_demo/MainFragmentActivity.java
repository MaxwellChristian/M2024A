package in.maxwell.m2024a.test_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.maxwell.m2024a.R;
import in.maxwell.m2024a.test_demo.ui.main.MainFragment;

public class MainFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}