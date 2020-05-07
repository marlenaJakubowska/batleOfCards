package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> handCards;

    public Hand() {
        this.handCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.handCards.add(card);
    }

    public List<Card> getHandCards() {
        return handCards;
    }
}
