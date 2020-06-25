package com.virnarula.listify;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.virnarula.listify.model.Assignment;
import com.virnarula.listify.ui.CustomPagerAdapter;
import com.virnarula.listify.ui.ModelObject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainTabbedActivity extends AppCompatActivity {

    ArrayList<Assignment> myDay;
    ArrayList<Assignment> assignments;
    ArrayList<Assignment> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabbed);

        readFromFile();

        final CustomPagerAdapter adapter = new CustomPagerAdapter(this, null, null, null );
        final ViewPager viewPager = findViewById(R.id.view_pager2);
        viewPager.setAdapter(adapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewPager.getCurrentItem();
                Snackbar.make(view, "You are currently on the " + getString(ModelObject.values()[position].getmLayoutTitleID()) + " page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        writeToFile();
    }
    protected void readFromFile() {
        Log.i("IO", "Reading from file");

    }

    protected void writeToFile() {
        Log.i("IO", "Writing to file");
    }
}
