package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public boolean add(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) return false;
            System.out.println("Task already exists, not added");
        }

        this.tasks.add(task);
        System.out.println("Task added.");
        return true;
    }

    public ArrayList<Task> getAll() {
        return this.tasks;
    }

    public Task getTask(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) return t;
        }
        System.out.println("The task '" + task.getTaskName() + "' was not found.");
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
                System.out.println("Task '" + t.getTaskName() + "' set to complete.");
                return true;
            }
        }
        return false;
    }

    public boolean setTaskIncomplete(Task task) {
        for (Task t : this.tasks) {
            if (t.getTaskName().equals(task.getTaskName())) {
                t.setIncomplete();
                System.out.println("Task '" + t.getTaskName() + "' set to incomplete.");
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

    public ArrayList<Task> getTasksAlphabeticallyDesc() {
        if (this.tasks.isEmpty()) return null;

        ArrayList<Task> toReturn = new ArrayList<>(this.tasks);
        Collections.sort(toReturn, new TaskAlphabetAscSort());
        Collections.reverse(toReturn);
        return toReturn;
    }

}
