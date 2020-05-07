package com.codecool.battleofcards;

import java.util.List;

public abstract class Player {

    protected List<Card> listOfCards;
    protected Card topcard;

    protected String name;
    private Hand hand;
    public Player(String name){

    }

    public Player() {
        this.hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    private String createName() {
        return name = name;
    }

//    public List<Card> getListOfCards(){
//        return listOfCards;
//    }

//    public Card getTopcard(){
//        return topcard;
//    }
}
