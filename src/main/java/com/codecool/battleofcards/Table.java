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
        this.currentCards = new ArrayList<>();
        Deck deck = cardReader.getDeck();
        shuffleCards(deck);

        currentCards.add(deck.getCards().get(0));
        currentCards.add(deck.getCards().get(1));
        currentCards.add(deck.getCards().get(2));
        currentCards.add(deck.getCards().get(3));

        printFourCards(currentCards);

    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void printCard(Card card) {
        String[] headers = {card.getCardName()};
        String[][] data = {{card.attributesToString()}};
        System.out.println(FlipTable.of(headers, data));
    }

    public void printFourCards(List<Card> listOfCards){

        String[] headers = {listOfCards.get(0).getCardName(),
                            listOfCards.get(1).getCardName(),
                            listOfCards.get(2).getCardName(),
                            listOfCards.get(3).getCardName()};

        String[][] data = {{listOfCards.get(0).attributesToString(),
                            listOfCards.get(1).attributesToString(),
                            listOfCards.get(2).attributesToString(),
                            listOfCards.get(3).attributesToString()}};

        System.out.println(FlipTable.of(headers, data));
    }


}