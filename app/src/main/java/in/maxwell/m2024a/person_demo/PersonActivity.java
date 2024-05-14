package in.maxwell.m2024a.person_demo;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024a.R;
import in.maxwell.m2024a.student_demo.StudentAdapter;

public class PersonActivity extends AppCompatActivity {

    RecyclerView rvPersonList;
    ArrayList<Person> alPersonList;
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alPersonList = new ArrayList<>();
        alPersonList.add(new Person("Maxwell", "Christian", "1981", Person.Gender.MALE, "A1", "A2", "Regina", "Saskatchewan", "X1X X2X"));
        alPersonList.add(new Person("Alex", "Wang", "1980", Person.Gender.MALE, "A11", "A22", "Regina", "Saskatchewan", "X1X X2X"));
        alPersonList.add(new Person("Christa", "Wunsch", "1980", Person.Gender.FEMALE, "A11", "A22", "Regina", "Saskatchewan", "X1X X2X"));

        personAdapter = new PersonAdapter(alPersonList);

        setContentView(R.layout.activity_person);

        rvPersonList = findViewById(R.id.rvPersonList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(PersonActivity.this);
        rvPersonList.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvPersonList.getContext(), layoutManager.getOrientation());
        rvPersonList.addItemDecoration(dividerItemDecoration);

        rvPersonList.setAdapter(personAdapter);

        personAdapter.setOnPersonClickListener((position, person) -> {
            Log.d("PersonActivity", "Person: " + person.getFirstName() + " " + person.getLastName());
        });

        registerForContextMenu(rvPersonList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_context_operations, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        Log.d("PersonActivity", "onContextItemSelected");
        RecyclerView.Adapter<StudentAdapter.StudentViewHolder> selectedView = ((RecyclerView.Adapter<StudentAdapter.StudentViewHolder>) item.getMenuInfo());


        return super.onContextItemSelected(item);
    }
}