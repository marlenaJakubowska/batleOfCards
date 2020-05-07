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

        printPlayerCards(deck);

    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void printPlayerCards() {
        String[] innerHeaders = {"gamename"};
        String[][] innerData = { { "attributes"} };
        String inner = FlipTable.of(innerHeaders, innerData);
        String[] headers = {"Player1", "Player2"};
        String[][] data = { { inner, inner } };
        System.out.println(FlipTable.of(headers, data));
    }


}