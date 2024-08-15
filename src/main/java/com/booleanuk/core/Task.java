package com.booleanuk.core;

public class Task {

    private String taskName;
    private boolean status;

    public Task(String taskName) {
        this.taskName = taskName;
        this.status = false; // Setting to false, i.e. incomplete from beginning
    }

    public Task() {

    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setComplete() {
        this.status = true;
    }

    public void setIncomplete() {
        this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }

}
