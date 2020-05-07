package com.codecool.battleofcards;

public class HumanPlayer extends Player{

    public HumanPlayer(String name) {
        super(name);
    }

    public String chooseCardAttributeToCompare(){
        return "string";
    }
}
