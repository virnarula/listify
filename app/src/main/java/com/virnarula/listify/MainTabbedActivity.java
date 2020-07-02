package com.virnarula.listify;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.virnarula.listify.model.Task;
import com.virnarula.listify.ui.CustomPagerAdapter;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainTabbedActivity extends AppCompatActivity {

    List<Task> myDay;
    List<Task> assignments;
    List<Task> history;
    private ViewPager viewPager;
    private CustomPagerAdapter adapter;
    private TabLayout tabs;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabbed);

        readFromFile();

        myDay = createSampleData();
        assignments = createSampleData();
        history = createSampleData();
        addTask();

        initializeFields();
        setListeners();

        writeToFile();
    }

    protected void initializeFields() {
        adapter = new CustomPagerAdapter(this, myDay, assignments, history );
        viewPager = findViewById(R.id.view_pager2);
        tabs = findViewById(R.id.tabs);
        fab = findViewById(R.id.fab);
    }

    protected void setListeners() {
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int position = viewPager.getCurrentItem();
//                Snackbar.make(view, "You are currently on the " + getString(ModelObject.values()[position].getmLayoutTitleID()) + " page", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                createTask();
            }
        });
    }

    protected void readFromFile() {
        Log.i("IO", "Reading from file");
        myDay = new ArrayList<>();
        assignments= new ArrayList<>();
        history = new ArrayList<>();
    }

    protected void writeToFile() {
        Log.i("IO", "Writing to file");
    }

    private List<Task> createSampleData() {
        List<Task> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            list.add(task);
        }
        return list;
    }

    private void addTask() {
        Intent intent = getIntent();
        if(intent.hasExtra("task")) {
            Task toAdd = (Task) intent.getSerializableExtra("task");
            assignments.add(0, toAdd);
        }
    }

    private void createTask() {
        Intent intent = new Intent(this, createAssignment.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
