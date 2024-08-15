package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class TodoListTestExtension {

    public TodoListTestExtension() {

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

    @Test
    public void testGetSingleTask() {
        TodoList tl = new TodoList();
        Task t = new Task("Do the dishes");

        tl.add(t);

        Assertions.assertEquals("Do the dishes", tl.getTask(t).getTaskName());
    }

    @Test
    public void testGetCompletedTest() {
        TodoList tl = new TodoList();
        tl.add(new Task("Do the dishes", true));
        tl.add(new Task("Do the laundry", true));
        tl.add(new Task("Vacuum", false));

        Assertions.assertEquals(2, tl.getCompleteTasks().size());

        tl = new TodoList();
        tl.add(new Task("Do the dishes", false));
        tl.add(new Task("Do the laundry", false));
        tl.add(new Task("Vacuum", false));

        Assertions.assertEquals(0, tl.getCompleteTasks().size());
    }

    @Test
    public void testGetIncompletedTest() {
        TodoList tl = new TodoList();
        tl.add(new Task("Do the dishes", true));
        tl.add(new Task("Do the laundry", true));
        tl.add(new Task("Vacuum", false));

        Assertions.assertEquals(1, tl.getIncompleteTasks().size());

        tl = new TodoList();
        tl.add(new Task("Do the dishes", false));
        tl.add(new Task("Do the laundry", false));
        tl.add(new Task("Vacuum", false));

        Assertions.assertEquals(3, tl.getIncompleteTasks().size());
    }

    @Test
    public void testSetTaskCompleteInTodoList() {
        TodoList tl = new TodoList();
        tl.add(new Task("Do the dishes", false));

        tl.setTaskComplete(new Task("Do the dishes"));

        Assertions.assertTrue(tl.getTask(new Task("Do the dishes")).getStatus());
    }

    @Test
    public void testSetTaskIncompleteInTodoList() {
        TodoList tl = new TodoList();
        tl.add(new Task("Do the dishes", true));

        tl.setTaskIncomplete(new Task("Do the dishes"));

        Assertions.assertFalse(tl.getTask(new Task("Do the dishes")).getStatus());
    }

    @Test
    public void testGetTasksInAlphabeticallyAscOrder() {
        TodoList tl = new TodoList();
        ArrayList<Task> listSorted = new ArrayList<>();

        Task t1 = new Task("Do the dishes");
        Task t2 = new Task("Vacuum");
        Task t3 = new Task("Go shopping");
        Task t4 = new Task("Ask for food");

        tl.add(t1);
        tl.add(t2);
        tl.add(t3);
        tl.add(t4);
        listSorted.add(t1);
        listSorted.add(t2);
        listSorted.add(t3);
        listSorted.add(t4);
        Collections.sort(listSorted, new TaskAlphabetAscSort());

        ArrayList<Task> givenSorted = tl.getTasksAlphabeticallyAsc();
        boolean bol = true;
        for (int i = 0; i < listSorted.size(); i++) {
            if (!givenSorted.get(i).getTaskName().equals(listSorted.get(i).getTaskName())) {
                bol = false;
                break;
            }
        }

        Assertions.assertTrue(bol);
    }

    @Test
    public void testGetTasksInAlphabeticallyDescOrder() {
        TodoList tl = new TodoList();
        ArrayList<Task> listSorted = new ArrayList<>();

        Task t1 = new Task("Do the dishes");
        Task t2 = new Task("Vacuum");
        Task t3 = new Task("Go shopping");
        Task t4 = new Task("Ask for food");

        tl.add(t1);
        tl.add(t2);
        tl.add(t3);
        tl.add(t4);
        listSorted.add(t1);
        listSorted.add(t2);
        listSorted.add(t3);
        listSorted.add(t4);
        Collections.sort(listSorted, new TaskAlphabetAscSort());
        Collections.reverse(listSorted);

        ArrayList<Task> givenSorted = tl.getTasksAlphabeticallyDesc();
        boolean bol = true;
        for (int i = 0; i < listSorted.size(); i++) {
            if (!givenSorted.get(i).getTaskName().equals(listSorted.get(i).getTaskName())) {
                bol = false;
                break;
            }
        }

        Assertions.assertTrue(bol);
    }

    @Test
    public void testGetTaskById() {
        TodoList tl = new TodoList();

        tl.add(new Task("Do the dishes"));
        tl.add(new Task("Vacuum"));

        Assertions.assertEquals("Do the dishes", tl.getTaskById(1).getTaskName());
        Assertions.assertEquals("Vacuum", tl.getTaskById(2).getTaskName());
    }

    @Test
    public void testUpdateTaskByGivingId() {
        TodoList tl = new TodoList();

        tl.add(new Task("Do the dishes"));
        tl.add(new Task("Vacuum"));

        tl.updateTask(2, "Vacuum, again...");

        Assertions.assertEquals(tl.getTaskById(1).getTaskName(), "Do the dishes");
        Assertions.assertEquals(tl.getTaskById(2).getTaskName(), "Vacuum, again...");
    }

    @Test
    public void testGetDateAndTimeFromCreatedTask() {
        TodoList tl = new TodoList();

        tl.add(new Task("Do the dishes"));
        tl.add(new Task("Vacuum"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();

        Assertions.assertEquals(tl.getTask(new Task("Do the dishes")).getCreated(), dtf.format(now));
    }

    @Test
    public void testUpdateTaskStatusByGivingId() {
        TodoList tl = new TodoList();

        tl.add(new Task("Do the dishes", false));
        tl.add(new Task("Vacuum", true));

        tl.updateTaskStatus(1, false);

        Assertions.assertFalse(tl.getTaskById(1).getStatus());
        Assertions.assertTrue(tl.getTaskById(2).getStatus());
    }

}
