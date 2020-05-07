package com.codecool.battleofcards;

import java.util.List;

public abstract class Player {

    protected List<Card> listOfCards;
    protected Card topCard;

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

    public abstract String chooseStatToCompare();

    public Hand getHand() {
        return this.hand;
    }

    public Card getTopCard() {
        return hand.getHandCards().get(0);
    }

//    public List<Card> getListOfCards(){
//        return listOfCards;
//    }

//    public Card getTopcard(){
//        return topcard;
//    }
}
