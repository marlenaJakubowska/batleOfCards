package com.codecool.battleofcards;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final String cardName;
    //private final String type;
    private Map<String, Float> cardStats;

    public Card(String cardName, HashMap<String, Float> cardStats) {
        this.cardName = cardName;
        //this.type = type;
        this.cardStats = cardStats;
    }

    public String getCardName() { return this.cardName;}

    public Map<String, Float> getCardStats() {return this.cardStats;}

    //public int getValueByType(String type) {return this.cardStats.get(type);}

    //public void setCardStatByType(String type, int value) {this.cardStats.put(type, value);}
}

