package com.codecool.battleofcards;

public class Menu {

    public UI ui = new UI();
    public Game game = new Game();

    public void startMenu() {
        boolean isRunning = true;
        while (isRunning) {
            this.ui.printMainMenu();
            int option = ui.takeIntegerInput("Choose option: ");

            switch (option) {
                case 1: {
                    this.ui.printSelectionMenu();
                    int selectedOption = ui.takeIntegerInput("Choose option: ");
                switch (selectedOption) {
                    case 1:
                        game.init();
                        isRunning = false;
                        break;
                    case 2:
                        System.out.println("Work in progress. Press 1");
                        break;
                    case 3 :
                        System.out.println("Work in progress. Press 1");
                        break;
                }
                break;
            }
                case 2: {
                    this.ui.printAbout();
                    break;
                }
                case 0: {
                    isRunning = false;
                }
            }
        }
    }
}
