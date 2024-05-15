package in.maxwell.m2024a.person_demo;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import in.maxwell.m2024a.R;

public class EditPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        Person person = (Person) bundle.getSerializable("person_to_edit");

        Log.d("EditPersonActivity", "Person to edit: " + person);

        setContentView(R.layout.activity_edit_person);

        // once edit and clicked to confirm
        // save the edited record in the database

        // start the list activity again
        // finish this activity

    }
}