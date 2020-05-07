package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table2 {

    private Deck deck;
    private List<Player> playerList;
    private List<AI> aiList;
    private UI ui;
    private List<Card> tableCards;
    private int numberOfPlayers;

    public Table2(CardReader cardReader) {
        createUI();
        createTableStuff(cardReader);

    }

    public void createTableStuff(CardReader cardReader) {
        this.deck = cardReader.getDeck();
        this.playerList = new ArrayList<>();
        this.tableCards = new ArrayList<>();
        createAIPlayer();
        createHumanPlayer();
        numberOfPlayers = playerList.size();

    }

    private void createUI() {
        this.ui = new UI();
    }

    public void createHumanPlayer() {
        playerList.add(new HumanPlayer());
    }
    public void createAIPlayer() { playerList.add(new AI());}

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void giveCards() {
        shuffleCards(deck);
        int numberOfCards = deck.getCards().size();
        for(int i = 0; i < numberOfCards; i++) {
            if (i % 2 == 0) {
                playerList.get(0).getHand().addCard(deck.getCards().get(i));
            } else {
                playerList.get(1).getHand().addCard(deck.getCards().get(i));
            }
        }
    }

    private int compareTopCards(String attributeChoice, Player currentPlayer, Player rivalPlayer) {
        Float currentPlayerAttrValue = currentPlayer.getTopCard().getValueByType(attributeChoice);
        Float rivalPlayerAttrValue = rivalPlayer.getTopCard().getValueByType(attributeChoice);
        int compare= currentPlayerAttrValue.compareTo(rivalPlayerAttrValue);
        return compare;

    }
    private void printCompareResult(int compareResult, Player currentPlayer, Player rivalPlayer) {
        if(compareResult == 0) {
            System.out.println("Tie. Play on");
        } else if(compareResult == 1) {
            System.out.println(currentPlayer.name + "wins the round");
        } else {
            System.out.println("No luck this time. " + rivalPlayer.name + " wins this time");
        }
    }
}
