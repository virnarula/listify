package com.virnarula.listify.model;

import java.util.ArrayList;

public class Assignment {
    ArrayList<Task> tasks;
    private long startTime, endTime;
    private Status status;
    private Priority priority;
    private String name;

    public Assignment(String name) {
        tasks = new ArrayList<Task>();
        this.name = name;
        priority = Priority.MEDIUM;
        status = Status.NOT_STARTED;
        startTime = -1;
        endTime = -1;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
