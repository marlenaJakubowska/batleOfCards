package com.codecool.battleofcards;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final String cardName;
    private final String type;
    private Map<String, Integer> cardStats;

    public Card(String cardName, String type) {
        this.cardName = cardName;
        this.type = type;
        this.cardStats = new HashMap<>();
    }

    public String getCardName() { return this.cardName;}

    public Map<String, Integer> getCardStats() {return this.cardStats;}

    public int getValueByType(String type) {return this.cardStats.get(type);}

    public void setCardStatByType(String type, int value) {this.cardStats.put(type, value);}
}

