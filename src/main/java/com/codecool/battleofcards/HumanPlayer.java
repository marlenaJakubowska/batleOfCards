package com.codecool.battleofcards;

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
}
