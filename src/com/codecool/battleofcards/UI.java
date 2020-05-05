package com.codecool.battleofcards;

import java.util.Scanner;

public class UI {
    private final Scanner scanner = new Scanner(System.in);

    public String takeStringInput(String messageForUser){
        System.out.println(messageForUser);
        return scanner.next();

    }
    public int takeIntegerInput(String messageForUser){
        System.out.print(messageForUser);
        return scanner.nextInt();
    }

    public void printMainMenu() {
        System.out.println("Welcome to Battle of Cards Game. Please choose an option:\n"
                         + "1. New Game\n"
                         + "2. About\n"
                         + "0. Exit");
    }
}

