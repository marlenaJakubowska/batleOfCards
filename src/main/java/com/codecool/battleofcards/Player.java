package com.codecool.battleofcards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
    protected List<Card> listOfCards;
    protected Card topCard;
    protected String name;
    private Hand hand;

    public Player() {
        this.hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    private String createName() {
        return name = name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public Card getTopCard() {
        return hand.getHandCards().get(0);
    }

    public void removeTopCard() {
        hand.getHandCards().remove(0);
    }

    public void addRoundCardsToHand(List<Card> roundCards) {
        for (Card card : roundCards) {
            hand.addCard(card);
        }
    }

    public abstract String chooseStatToCompare();

    public Map<Integer, String> statChoiceMap() {
        Map<Integer, String> attributeChoice = new HashMap<>();
        attributeChoice.put(1, "ourScore" );
        attributeChoice.put(2, "criticScore");
        attributeChoice.put(3, "publicationYear");
        attributeChoice.put(4, "userScore");
        return attributeChoice;
    }

    public void printStatsToChoose(Map<Integer, String> attributeChoice) {
        System.out.println("Choose attribute to compare: ");
        attributeChoice.forEach((k,v) -> System.out.println(k+" " +v));
    }



}
