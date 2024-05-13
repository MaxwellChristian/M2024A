package in.maxwell.m2024a.student_demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024a.ColorMixer;
import in.maxwell.m2024a.R;

public class StudentActivity extends AppCompatActivity {

    RecyclerView rvStudent;
    ArrayList<Student> alStudents;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student);

        rvStudent = findViewById(R.id.rvStudent);

        LinearLayoutManager layoutManager =  new LinearLayoutManager(StudentActivity.this);
        rvStudent.setLayoutManager(layoutManager);

        alStudents = new ArrayList<>();
        alStudents.add(new Student("S1", "Maxwell", "Christian", 1, "Regina"));
        alStudents.add(new Student("S2", "Alex", "Wang", 1, "Regina"));
        alStudents.add(new Student("S3", "Christa", "Wunsch", 0, "Regina"));

        studentAdapter = new StudentAdapter(alStudents);
        rvStudent.setAdapter(studentAdapter);

        studentAdapter.setOnStudentClickListener((position, student) -> {
            Log.d("Student", student.toString());

            Intent colorIntent =  new Intent(StudentActivity.this, ColorMixer.class);

            colorIntent.putExtra("selected_student", student);

            startActivity(colorIntent);

        });
    }
}