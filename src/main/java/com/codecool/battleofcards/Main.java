package com.codecool.battleofcards;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        UI ui = new UI();
        System.out.println("pierwsza dupa");
        ui.clearScreen();
        System.out.println("druga dupa");
        menu.startMenu();
    }
}
