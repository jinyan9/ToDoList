package sg.edu.rp.c346.id22022452.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnAdd,btnDelete,btnClear,btnupdate;
    ListView todo;
    EditText input;
    ArrayList<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);
        todo = findViewById(R.id.todoList);
        input = findViewById(R.id.input);
        //buttonupdate = findViewById(R.id.btnupdate);

        todoList = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,todoList);
        todo.setAdapter(adapter);

        //Choose Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        input.setHint("Type in a new task here to add");
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Task = input.getText().toString();
                            todoList.add(Task);
                            adapter.notifyDataSetChanged();
                            }
                        });
                        break;

                    case 1:
                        input.setHint("Type in the index of the task here to delete");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        btnDelete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int pos = Integer.parseInt(input.getText().toString());
                                if (todoList.isEmpty())
                                {
                                    Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                                } else if (pos >= todoList.size()) {
                                    Toast.makeText(MainActivity.this, "Wrong index number provided", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    todoList.remove(pos);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Creating ArrayList to put tasks inside
//        todoList = new ArrayList<>();
//        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,todoList);
//        todo.setAdapter(adapter);

        // Adding Tasks
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Task = input.getText().toString();
//                todoList.add(Task);
//                adapter.notifyDataSetChanged();
//            }
//        });
//
//        // Deleting Tasks
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int pos = Integer.parseInt(input.getText().toString());
//
//                todoList.remove(pos);
//                adapter.notifyDataSetChanged();
//            }
//        });
//        buttonupdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String colour = input.getText().toString();
//                //alColours.add(etElement.getText().toString());
//                int pos = Integer.parseInt(input.getText().toString());
//                alColours.set(pos,colour);
//                aaColour.notifyDataSetChanged();
//
//            }
//        });
        // Clearing Tasks
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoList.clear();
                adapter.notifyDataSetChanged();
            }
        });


    }
}