package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner sc;

    public ConsoleUI() {
        this.sc = new Scanner(System.in);
    }

    public int getUserInt(String prompt) {
        System.out.println(prompt);
        return sc.nextInt();
    }

    public String getUserString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public void printMessage(String prompt) {
        System.out.println(prompt);
    }

    public void printTodoListLatest(ArrayList<Task> tasks) {

    }

    public void printTodoListAlphabetAsc(ArrayList<Task> tasks) {

    }

    public void printTodoListAlphabetDesc(ArrayList<Task> tasks) {

    }

}
