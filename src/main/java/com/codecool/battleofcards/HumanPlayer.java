package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanPlayer extends Player{

    private UI ui = new UI();

    public HumanPlayer(String name) {
        super(name);
    }

    public HumanPlayer() {
        this.name = createName();
    }

    public String chooseCardAttributeToCompare(){
        String statToCompare;
        return statToCompare = ui.takeStringInput("choose attribute");
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
            input = ui.takeIntegerInput("1 - 4");
            if (input > 0 && input < 5) {
                isRunning = false;
            }
        }
        return attributeChoice.get(input);
    }

    private Map<Integer, String> statChoiceMap() {
        Map<Integer, String> attributeChoice = new HashMap<>();
        attributeChoice.put(1, "ourScore" );
        attributeChoice.put(2, "criticScore");
        attributeChoice.put(3, "publicationYear");
        attributeChoice.put(4, "userScore");
        return attributeChoice;
    }
    private void printStatsToChoose(Map<Integer, String> attributeChoice) {
        System.out.println("Choose attribute to compare: ");
        attributeChoice.forEach((k,v) -> System.out.println(k+" " +v));
    }
}
