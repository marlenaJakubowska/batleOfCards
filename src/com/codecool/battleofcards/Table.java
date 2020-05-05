package com.codecool.battleofcards;

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

}