package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {

    public TodoListTest() {

    }

    @Test
    public void testCreateTask() {
        Task t = new Task("Do the dishes");
        Assertions.assertEquals("Do the dishes", t.getTaskName());
    }

    @Test
    public void testAddTaskToTodoList() {
        TodoList tl = new TodoList();
        Assertions.assertTrue(tl.add(new Task("Do the dishes")));
    }

    @Test
    void testAddTaskToTodoListAlreadyExists() {
        TodoList tl = new TodoList();
        Assertions.assertTrue(tl.add(new Task("Do the dishes")));
        Assertions.assertFalse(tl.add(new Task("Do the dishes")));
    }

}
