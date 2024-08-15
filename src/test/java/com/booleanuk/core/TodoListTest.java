package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TodoListTest {

    public TodoListTest() {

    }

    @Test
    public void testCreateTask() {
        Task t = new Task("Do the dishes");
        Assertions.assertEquals("Do the dishes", t.getTaskName());
    }

    @Test
    public void testChangeTaskStatus() {
        Task t = new Task();

        t.setComplete();
        Assertions.assertTrue(t.getStatus());

        t.setIncomplete();
        Assertions.assertFalse(t.getStatus());
    }

    @Test
    public void testAddTaskToTodoList() {
        TodoList tl = new TodoList();
        Assertions.assertTrue(tl.add(new Task("Do the dishes")));
    }

    @Test
    public void testAddTaskToTodoListAlreadyExists() {
        TodoList tl = new TodoList();
        Assertions.assertTrue(tl.add(new Task("Do the dishes")));
        Assertions.assertFalse(tl.add(new Task("Do the dishes")));
    }

    @Test
    public void testgetAllTasks() {
        TodoList tl = new TodoList();
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Do the dishes"));
        tasks.add(new Task("Do the laundry"));
        tasks.add(new Task("Vacuum"));

        for (Task t : tasks) {
            tl.add(t);
        }

        Assertions.assertEquals(tasks, tl.getAll());
    }


}
