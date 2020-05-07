package com.codecool.battleofcards;

import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {

    private List<Card> listOfCards;
    private List<Card> currentCards;
    
    public List<Card> getTableListOfCards(){
        return listOfCards;
    }

    public List<Card> getTableCurrentCards(){
        return currentCards;
    }

    public Table(){
        CardReader cardReader = new CardReader();
        Deck deck = cardReader.getDeck();
        shuffleCards(deck);

        printCard(deck.getCards().get(0));
        printCard(deck.getCards().get(1));
        printCard(deck.getCards().get(2));

    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void printCard(Card card) {
        String[] headers = {card.getCardName()};
        String[][] data = {{card.attributesToString()}};
        System.out.print(FlipTable.of(headers, data));
    }


}