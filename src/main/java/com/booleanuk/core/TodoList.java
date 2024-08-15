package com.booleanuk.core;

import java.util.ArrayList;

public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public boolean add(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) return false;
        }

        this.tasks.add(task);
        return true;
    }
}
