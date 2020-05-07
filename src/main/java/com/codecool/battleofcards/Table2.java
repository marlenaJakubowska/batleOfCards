package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table2 {

    private Deck deck;
    private List<HumanPlayer> humanPlayerList;
    private List<AI> aiList;
    private UI ui;

    public Table2(CardReader cardReader) {
        createUI();
        assignObjectsToTable(cardReader);

    }

    public void assignObjectsToTable(CardReader cardReader) {
        this.deck = cardReader.getDeck();
        this.humanPlayerList = new ArrayList<>();

    }

    private void createUI() {
        this.ui = new UI();
    }

    public void createHumanPlayer() {
        humanPlayerList.add(new HumanPlayer());
    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }
}
