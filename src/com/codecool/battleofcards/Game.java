package com.codecool.battleofcards;

import java.util.Arrays;

public class Game {

    public void init() {
        CardReader cardReader = new CardReader();
        System.out.println("List of cards:");
        printCards(cardReader.getDeck());
    }

    public void printCards(Deck deck) {
        for (Card card : deck.getCards()) {
            System.out.println(card.getCardName());
            System.out.println(card.getCardStats());
            System.out.println("value by criticScore: " + card.getValueByType("criticScore"));
            System.out.println("__________________________-");
        }
    }
}



