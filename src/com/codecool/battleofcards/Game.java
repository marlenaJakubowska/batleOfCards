package com.codecool.battleofcards;

public class Game {

    public void init() {
        //System.out.println("hello");
        XMLReader documentReader = new XMLReader();
        documentReader.readXMLDocument("cards.xml");
        documentReader.createCardFromXMLData();
    }
}
