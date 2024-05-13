package in.maxwell.m2024a.student_using_database;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

import in.maxwell.m2024a.ColorMixer;
import in.maxwell.m2024a.R;

public class StudentActivity extends AppCompatActivity {

    RecyclerView rvStudent;
    FloatingActionButton fabAddStudent;
    ArrayList<Student> alStudents;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student);

        rvStudent = findViewById(R.id.rvStudent);
        fabAddStudent = findViewById(R.id.fabAddStudent);

        fabAddStudent.setOnClickListener( v -> addStudentRecord() );

        LinearLayoutManager layoutManager =  new LinearLayoutManager(StudentActivity.this);
        rvStudent.setLayoutManager(layoutManager);

//        alStudents = new ArrayList<>();
//        alStudents.add(new Student("S1", "Maxwell", "Christian", 1, "Regina"));
//        alStudents.add(new Student("S2", "Alex", "Wang", 1, "Regina"));
//        alStudents.add(new Student("S3", "Christa", "Wunsch", 0, "Regina"));

        try {
            DBHelper dbHelper = new DBHelper(StudentActivity.this);

            // add some testing records to database
//            dbHelper.addStudent( new Student("S1", "Maxwell-", "Christian", 1, "Regina"));
//            dbHelper.addStudent( new Student("S2", "Alex-", "Wang", 1, "Regina"));
//            dbHelper.addStudent( new Student("S3", "Christa-", "Wunsch", 0, "Regina"));

            alStudents = dbHelper.getAllStudents();

            studentAdapter = new StudentAdapter(alStudents);
            rvStudent.setAdapter(studentAdapter);

            studentAdapter.setOnStudentClickListener((position, student) -> {
                Log.d("Student", student.toString());

                Intent colorIntent =  new Intent(StudentActivity.this, ColorMixer.class);

                colorIntent.putExtra("selected_student", student);

                startActivity(colorIntent);

            });
        } catch (Exception e) {
            Log.e("StudentActivity", Objects.requireNonNull(e.getMessage()));
        }

    }

    private void addStudentRecord() {

        Intent addStudentIntent =  new Intent(StudentActivity.this, AddStudentActivity.class);
        startActivity(addStudentIntent);

    }
}