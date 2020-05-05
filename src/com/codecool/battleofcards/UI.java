package com.codecool.battleofcards;

import java.util.Scanner;

public class UI {
    public final Scanner scanner = new Scanner(System.in);

    public void printMainMenu() {
        System.out.println("Welcome to Battle of Cards Game. Please choose an option:");
        System.out.println("1. New Game");
        System.out.println("2. About");
        System.out.println("0. Exit");
    }
}

