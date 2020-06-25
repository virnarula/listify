package com.virnarula.listify.model;

public class Task {
    private long startTime, endTime;
    private Status status;
    private Priority priority;
    private String name;

    public Task(String name) {
        this.name = name;
        priority = Priority.MEDIUM;
        status = Status.NOT_STARTED;
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

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}

enum Status {
    NOT_STARTED,
    CURRENT,
    COMPLETE
}
