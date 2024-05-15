package in.maxwell.m2024a.student_using_database;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
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

        registerForContextMenu(rvStudent);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.student_record_operations, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.cmiStudentEdit) {
            // edit the selected student
            Log.d("StudentActivity", "In Edit: " + studentAdapter.getSelectedStudent());
        }

        if (item.getItemId() == R.id.cmiStudentRemove) {
            // remove the selected student
            Log.d("StudentActivity", "In Remove: " + studentAdapter.getSelectedStudent());
        }

        return super.onContextItemSelected(item);

    }

    private void addStudentRecord() {

        Intent addStudentIntent =  new Intent(StudentActivity.this, AddStudentActivity.class);
        startActivity(addStudentIntent);

    }
}