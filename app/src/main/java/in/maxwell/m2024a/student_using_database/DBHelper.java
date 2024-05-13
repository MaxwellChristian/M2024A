package in.maxwell.m2024a.student_using_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context) {
        this(context, "dbStudents", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create tables

        // creating table student
        String query = "";

        query = "CREATE TABLE tblStudents " +
                "(" +
                "studentID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "studentFirstName TEXT, " +
                "studentLastName TEXT, " +
                "studentGender INTEGER, " +
                "studentCity TEXT" +
                ")";
        Log.d("TBL Students", query);

        db.execSQL(query);
        Log.d("TBL Students", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drop the existing tables

        // create new tables (using onCreate)

    }

    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> alStudents = new ArrayList<>();

        // fetch all student data from the table of database

        // get a reference to readable database
        SQLiteDatabase db = getReadableDatabase();

        // query the table to fetch the required fields
        Cursor resultSet = db.query("tblStudents",
                new String[]{"studentID", "studentFirstName", "studentLastName", "studentGender", "studentCity"},
                null, null, null, null, null);

        // convert each fetched record to appropriate object (to return)
        while (resultSet.moveToNext()) {
            Student student = new Student();
            student.setStudentID(String.valueOf(resultSet.getInt(0)));
            student.setFirstName(resultSet.getString(1));
            student.setLastName(resultSet.getString(2));
            student.setGender(resultSet.getInt(3));
            student.setCity(resultSet.getString(4));

            alStudents.add(student);
        }

        return alStudents;
    }

    public long addStudent(Student student) {

        // get a reference to writable database
        SQLiteDatabase db = getWritableDatabase();

        // create a content values object (one record)
        ContentValues values = new ContentValues();
        values.put("studentFirstName", student.getFirstName());
        values.put("studentLastName", student.getLastName());
        values.put("studentGender", student.getGender());
        values.put("studentCity", student.getCity());

        // insert the record into the database
        return db.insert("tblStudents", null, values);
    }
}
