package com.codecool.battleofcards;

import java.util.Collections;
import java.util.List;

public class Table {

    private List<Card> listOfCards;
    private List<Card> currentCards;
    
    public List<Card> tableListOfCards(){
        return listOfCards;
    }

    public List<Card> tableCurrentCards(){
        return currentCards;
    }

    public Table(){
        CardReader cardReader = new CardReader();
        System.out.println("List of cards:");
        printCards(cardReader.getDeck());  // test
        shuffleCards(cardReader.getDeck()); // test
        printCards(cardReader.getDeck()); // test
    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void printCards(Deck deck) {  //test
        for (Card card : deck.getCards()) {
            System.out.println(card.getCardName());
            System.out.println(card.getCardStats());
            System.out.println("value by criticScore: " + card.getValueByType("criticScore"));
            System.out.println("__________________________-");
        }
    }


}