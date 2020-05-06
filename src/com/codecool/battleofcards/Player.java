package com.codecool.battleofcards;

import java.util.List;

public abstract class Player {
    private String name;
    protected List<Card> listOfCards;
    protected Card topcard;

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
