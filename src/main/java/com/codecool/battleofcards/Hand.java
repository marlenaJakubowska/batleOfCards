package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand {

    private List<Card> handCards;
    private Iterator<Card> cardIterator;

    public Hand() {
        this.handCards = new ArrayList<>();
        this.cardIterator = new CardIterator();
    }

    private class CardIterator implements Iterator<Card> {
        int index;

        @Override
        public boolean hasNext() {
            return index < handCards.size();
        }

        @Override
        public Card next() {
            if (this.hasNext()) {
                return handCards.get(index++);
            } else {
                return null;
            }
        }
    }

    public void addCard(Card card) {
        this.handCards.add(card);
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public Iterator<Card> getIterator() {
        return this.cardIterator;
    }
}
