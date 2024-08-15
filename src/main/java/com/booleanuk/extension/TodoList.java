package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();

        task.setId(this.tasks.size() + 1);
        task.setDateAndTimeCreated(dtf.format(now));

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

    public Task getTaskById(int id) {
        Task toReturn = null;
        for (Task t : this.tasks) {
            if (t.getId() == id) toReturn = t;
        }
        return toReturn;
    }

    public boolean updateTask(int id, String newTaskName) {
        for (Task t : this.tasks) {
            if (t.getId() == id) {
                t.setTaskName(newTaskName);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskStatus(int id, boolean status) {
        for (Task t : this.tasks) {
            if (t.getId() == id) {
                if (status) t.setComplete();
                else t.setIncomplete();
                return true;
            }
        }
        return false;
    }

}
