package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<Task> getAll() {
        return this.tasks;
    }

    public Task getTask(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) return t;
        }
        return null;
    }

    public ArrayList<Task> getCompleteTasks() {
        ArrayList<Task> toReturn = new ArrayList<Task>();

        for (Task t : this.tasks) {
            if (t.getStatus()) toReturn.add(t);
        }

        return toReturn;
    }

    public ArrayList<Task> getIncompleteTasks() {
        ArrayList<Task> toReturn = new ArrayList<Task>();

        for (Task t : this.tasks) {
            if (!t.getStatus()) toReturn.add(t);
        }

        return toReturn;
    }

    public boolean setTaskComplete(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) {
                t.setComplete();
                return true;
            }
        }
        return false;
    }

    public boolean setTaskIncomplete(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) {
                t.setIncomplete();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Task> getTasksAlphabeticallyAsc() {
        if (this.tasks.isEmpty()) return null;

        ArrayList<Task> toReturn = new ArrayList<>(this.tasks);
        Collections.sort(toReturn, new TaskAlphabetAscSort());
        return toReturn;
    }

}
