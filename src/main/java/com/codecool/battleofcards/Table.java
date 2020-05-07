package com.codecool.battleofcards;

import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
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
        Deck deck = cardReader.getDeck();
        printPlayerCards(deck);

    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void printPlayerCards(Deck deck) {
        String[] headers = {"Opponent card", "Your card"};
        String[][] content = {{deck.getCards().get(0).toString(), deck.getCards().get(1).toString()}};
        System.out.println(FlipTable.of(headers, content));
    }


}