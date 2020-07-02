package com.virnarula.listify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.virnarula.listify.model.Status;
import com.virnarula.listify.model.Task;
import com.virnarula.listify.model.Priority;

public class createAssignment extends AppCompatActivity {

    private TextView discard, create;
    private EditText title;
    private Spinner prioritySpinner, statusSpinner;
    private ArrayAdapter<Priority> priorities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_assignment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE|WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        initializeFields();
        setListeners();
    }

    protected void initializeFields() {
        discard = findViewById(R.id.discard_task);
        create = findViewById(R.id.create_task);
        title = findViewById(R.id.taskTitle);
        prioritySpinner = findViewById(R.id.priority_spinner);
        statusSpinner = findViewById(R.id.status_spinner);
    }

    protected void setListeners() {
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Discard Task");
                returnToHome();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Create Task");
                Snackbar.make(v, R.string.app_name, Snackbar.LENGTH_SHORT).show();
                createTask();
            }
        });

        ArrayAdapter<Priority> priorityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Priority.values());
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(priorityAdapter);
        prioritySpinner.setSelection(1);

        ArrayAdapter<Status> statusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Status.values());
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(statusAdapter);
        statusSpinner.setSelection(0);
    }

    @Override
    public void onBackPressed() {
        returnToHome();
    }

    private void createTask() {
        Task task = new Task(String.valueOf(title.getText()));
        task.setPriority((Priority) prioritySpinner.getSelectedItem());
        task.setStatus((Status) statusSpinner.getSelectedItem());

        Intent intent = new Intent(this, MainTabbedActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    private void returnToHome() {
        Intent intent = new Intent(this, MainTabbedActivity.class);
        startActivity(intent);
    }
}