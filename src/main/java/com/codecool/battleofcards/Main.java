package com.codecool.battleofcards;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        //test
        UI ui = new UI();
        System.out.println("pierwsza dupa");
        ui.clearScreen();
        System.out.println("druga dupa");
        AI ai = new AI();
        System.out.println(ai.getName());
        HumanPlayer human = new HumanPlayer();
        System.out.println(human.getName());



        menu.startMenu();
    }
}
