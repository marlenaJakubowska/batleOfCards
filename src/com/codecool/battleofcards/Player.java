package com.codecool.battleofcards;

import java.util.List;

public class Player {
    private String name;
    private List<Card> listOfCards;
    private Card topcard;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getListOfCards(){
        return listOfCards;
    }

    public Card getTopcard(){
        return topcard;
    }
}
