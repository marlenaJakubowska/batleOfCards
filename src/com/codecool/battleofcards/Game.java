package com.codecool.battleofcards;

public class Game {

    public void init() {
        //System.out.println("hello");
        XMLReader documentReader = new XMLReader();
        documentReader.readXMLDocument("cards.xml");
        Deck deck = new Deck();
        documentReader.createCardsInDeckFromXMLData(deck);

        for (Card card : deck.getCards()){
            System.out.println(card.getCardName());
            System.out.println(card.getCardStats());
            System.out.println("-----------------------------------");
        }

    }
}
