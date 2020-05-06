package com.codecool.battleofcards;

import java.util.*;

public class Card {

    private final String cardName;
    private Map<String, Float> cardStats;

    public Card(String cardName) {
        this.cardName = cardName;
        this.cardStats = new HashMap<>();
    }

    public String getCardName() { return this.cardName;}

    public Map<String, Float> getCardStats() {return this.cardStats;}

    public float getValueByType(String type) {return this.cardStats.get(type);}

    public void setCardStatByType(String type, float value) {this.cardStats.put(type, value);}

}

