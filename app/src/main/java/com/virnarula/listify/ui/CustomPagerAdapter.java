package com.virnarula.listify.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.virnarula.listify.R;
import com.virnarula.listify.model.Assignment;
import com.virnarula.listify.model.Task;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    List<Task> myDay;
    List<Task> assignments;
    List<Task> history;

    public CustomPagerAdapter(Context context, List<Task> myDay, List<Task> assignments, List<Task> history) {
        mContext = context;
        this.myDay = myDay;
        this.assignments = assignments;
        this.history = history;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getmLayoutResID(), container, false);
        switch (position){
            case 0:
                instantiateMyDay(layout);
                break;
            case 1:
                instantiateAssignments(layout);
                break;
            case 2:
                instantiateHistory(layout);
                break;
        }

        container.addView(layout);
        return layout;
    }

    public void instantiateMyDay(ViewGroup layout) {
        TextView textView = layout.findViewById(R.id.myDayTextView);
        if(myDay == null || myDay.size() == 0) {
            textView.setText("There are no tasks for my day so far");
        } else {
            textView.setText("There are " + myDay.size() + " tasks so far");
        }

        RecyclerView recyclerView = layout.findViewById(R.id.my_day_recycler);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    public void instantiateAssignments(ViewGroup layout) {
        TextView temp = layout.findViewById(R.id.assignmentTextView);
        if (assignments == null || assignments.size() == 0) {
            temp.setText("There are no tasks for so far");
        } else {
            temp.setText("There are " + assignments.size() + " tasks so far");
        }
    }

    public void instantiateHistory(ViewGroup layout) {
        TextView temp = layout.findViewById(R.id.historyTextView);
        if (history == null || history.size() == 0) {
            temp.setText("There are no tasks so far");
        } else {
            temp.setText("There are " + history.size() + " tasks so far");
        }
    }

    private void generateAssignmentCards(List<Assignment> assignmentList) {

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(ModelObject.values()[position].getmLayoutTitleID());
    }
}

