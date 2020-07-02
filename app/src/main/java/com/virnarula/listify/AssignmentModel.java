package com.virnarula.listify;

import com.virnarula.listify.model.Assignment;
import com.virnarula.listify.model.Task;

import java.util.ArrayList;

public class AssignmentModel {
    private String title;
    private ArrayList<Task> tasks;

    public AssignmentModel(String title) {
        this.title = title;
        tasks = new ArrayList<Task>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


}
