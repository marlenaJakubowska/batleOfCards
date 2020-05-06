package com.codecool.battleofcards;

import java.util.Arrays;

public class Game {
    public UI ui = new UI();

    public void init() {
        this.ui.printSelectNumberOfPlayers();
        int numOfPlayers = ui.takeIntegerInput("Number of rivals: ");
        for (int i = 0; i < numOfPlayers; i++){
            System.out.println("Player: " + 1 + i);
        }
        
        //System.out.println("hello");
        // XMLReader documentReader = new XMLReader();
        // documentReader.readXMLDocument("cards.xml");
        // Deck deck = new Deck();
        // documentReader.createCardsInDeckFromXMLData(deck);

        // for (Card card : deck.getCards()){
        //     System.out.println(card.getCardName());
        //     System.out.println(card.getCardStats());
        //     System.out.println("-----------------------------------");
        // }
        Table table = new Table();


    }


}



