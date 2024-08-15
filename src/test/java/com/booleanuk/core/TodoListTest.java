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
    public void testAddTaskExists() {
        TodoList tl = new TodoList();
        Assertions.assertFalse(tl.add(new Task("Do the dishes")), "Do the dishes");
    }

}
