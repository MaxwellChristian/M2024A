package in.maxwell.m2024a.student_using_database;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import in.maxwell.m2024a.R;

public class AddStudentActivity extends AppCompatActivity {

    EditText etStudentID;
    EditText etStudentFirstName;
    EditText etStudentLastName;

    Button btnAddStudent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_student);

        etStudentID = findViewById(R.id.etStudentID);
        etStudentFirstName = findViewById(R.id.etStudentFirstName);
        etStudentLastName = findViewById(R.id.etStudentLastName);

        btnAddStudent = findViewById(R.id.btnAddStudentRecord);

        btnAddStudent.setOnClickListener(v -> {

            // create a student object with values from the edit texts
            Student student = new Student();
            student.setStudentID(etStudentID.getText().toString());
            student.setFirstName(etStudentFirstName.getText().toString());
            student.setLastName(etStudentLastName.getText().toString());

            // get a reference to the database helper class
            DBHelper dbHelper = new DBHelper(AddStudentActivity.this);

            // add the record using helper class method
            dbHelper.addStudent(student);

        });
    }
}
