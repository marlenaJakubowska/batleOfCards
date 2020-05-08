package com.codecool.battleofcards;

import java.util.List;

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

}
