package com.booleanuk.core;

public class Task {

    private String taskName;
    private boolean status;

    public Task(String taskName) {
        this.taskName = taskName;
        this.status = false; // Setting to false, i.e. incomplete from beginning
    }

    public Task(String taskName, boolean status) {
        this.taskName = taskName;
        this.status = status;
    }

    public Task() {

    }

    public String getTaskName() {
        return this.taskName;
    }

    protected void setComplete() {
        this.status = true;
    }

    protected void setIncomplete() {
        this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }

}
