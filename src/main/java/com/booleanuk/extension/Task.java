package com.booleanuk.extension;

public class Task {

    private String taskName;
    private boolean status;
    private int id;
    private String created;

    public Task(String taskName) {
        this.taskName = taskName;
        this.status = false; // Setting to false, i.e. incomplete from beginning
    }

    public Task(String taskName, boolean status) {
        this.taskName = taskName;
        this.status = status;
    }

    protected Task(String taskName, int id) {
        this.taskName = taskName;
        this.id = id;
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

    public int getId() {
        return this.id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected void setTaskName(String newTaskName) {
        this.taskName = newTaskName;
    }

    protected void setDateAndTimeCreated(String time) {
        this.created = time;
    }

    public String getCreated() {
        return this.created;
    }

}
