package com.codecool.battleofcards;

import java.util.Map;

public class HumanPlayer extends Player{

    private UI ui = new UI();

        public HumanPlayer() {
            this.name = createName();
    }

    private String createName(){
        this.name = ui.takeStringInput("Enter player name");
        return name;

    }

    @Override
    public String chooseStatToCompare() {
        Map<Integer, String> attributeChoice = statChoiceMap();
        boolean isRunning = true;
        int input = 0;
        while(isRunning) {
            printStatsToChoose(attributeChoice);
            input = ui.takeIntegerInput("Choose attribute 1 - 4: ");
            if (input > 0 && input < 5) {
                isRunning = false;
            }
        }
        return attributeChoice.get(input);
    }
}
