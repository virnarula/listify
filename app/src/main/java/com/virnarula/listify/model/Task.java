package com.virnarula.listify.model;

import java.io.Serializable;

public class Task implements Serializable {
    private long startTime, endTime;
    private Status status;
    private Priority priority;
    private String name;

    public Task(String name) {
        this.name = name;
        priority = Priority.Medium;
        status = Status.Planned;
        startTime = -1;
        endTime = -1;
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

