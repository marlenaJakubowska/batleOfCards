package com.codecool.battleofcards;

import java.util.Scanner;

public class Menu {


    public UI ui = new UI();
    public Game game = new Game();

    public void startMenu() {
        boolean isRunning = true;
        while (isRunning) {
            this.ui.printMainMenu();
            int option = ui.scanner.nextInt();

            switch (option) {
                case 1: {
                    game.init();
                    isRunning = false;
                    break;
                }
                case 2: {
                    System.out.println("About - Work in progress");
                    break;
                }
                case 0: {
                    isRunning = false;
                }
            }
        }
    }
}
