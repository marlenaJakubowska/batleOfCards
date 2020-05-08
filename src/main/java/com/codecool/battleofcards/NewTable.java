package com.codecool.battleofcards;

import com.jakewharton.fliptables.FlipTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewTable {

    private Deck deck;
    private List<Player> playerList;
    private UI ui;
    private List<Card> cardsFromTie;
    private String xSign;

    private CardReader cardReader;

    public NewTable() {
        cardReader = new CardReader();
        createUI();
        createTableStuff(cardReader);
    }

    public void createTableStuff(CardReader cardReader) {

        this.deck = cardReader.getDeck();
        shuffleCards(deck);

        this.playerList = new ArrayList<>();
        this.cardsFromTie = new ArrayList<>();
        createAIPlayer();
        createHumanPlayer();
    }

    private void createUI() {
        this.ui = new UI();
        xSign = ui.getXSign();
    }

    public void playPVC() {
        giveCards();
        pvc();
    }

    public void createHumanPlayer() {
        playerList.add(new HumanPlayer());
    }

    public void createAIPlayer() {
        playerList.add(new AI());
    }

    public void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

    public void giveCards() {
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
            System.out.println(currentPlayer.name + " wins the round");
        } else {
            System.out.println("No luck this time. " + rivalPlayer.name + " wins this time");
        }
    }

    private boolean switchPlayers(Player currentPlayer, Player rivalPlayer, int compareResult, List<Card>roundCards) {
        if (compareResult == 0) {
            tieAction(currentPlayer, rivalPlayer,compareResult, roundCards);
        } else {
            if (compareResult > 0) {
                currentPlayerWinsAction(currentPlayer, rivalPlayer,compareResult, roundCards);
                //??????
                return false;
            } else {
                rivalPlayerWinsAction(currentPlayer, rivalPlayer,compareResult, roundCards);
                return true;
            }
        } return false;
    }
    
    private void pvc(){
        ui.clearScreen();
        Player ai = getPlayerList().get(0);
        Player humanPlayer = getPlayerList().get(1);
        boolean doesAIHaveCards = ai.getHand().getIterator().hasNext();
        boolean doesHumanPlayerHaveCards = humanPlayer.getHand().getIterator().hasNext();
        Player currentPlayer = humanPlayer;
        Player rivalPlayer = ai;
        while (doesAIHaveCards && doesHumanPlayerHaveCards) {
            List<Card> roundCards = new ArrayList<>();
            roundCards.add(currentPlayer.getTopCard());
            roundCards.add(rivalPlayer.getTopCard());
            printTable(currentPlayer, rivalPlayer, false, true);
            String attributeChoice = currentPlayer.chooseStatToCompare();
            System.out.println("-----------------------------");
            printTable(currentPlayer, rivalPlayer, true, false);
            int compareResult = compareTopCards(attributeChoice, currentPlayer, rivalPlayer);
            printCompareResult(compareResult, currentPlayer, rivalPlayer);
            boolean doneSwitching = switchPlayers(currentPlayer, rivalPlayer,compareResult,roundCards);
            if(doneSwitching) {
                if (currentPlayer == ai) {
                    currentPlayer = humanPlayer;
                    rivalPlayer = ai;
                } else {
                    currentPlayer = ai;
                    rivalPlayer = humanPlayer;
                }
            }
            doesAIHaveCards = ai.getHand().getIterator().hasNext();
            doesHumanPlayerHaveCards = humanPlayer.getHand().getIterator().hasNext();
            printTable(currentPlayer, rivalPlayer, false, true);
            printEndOfRound();
        }
        String gameResult = !doesHumanPlayerHaveCards ? ai.getName() : humanPlayer.getName();
        String winner = gameResult.equals("ai") ? ai.getName() : humanPlayer.getName();
        printEndGame(winner);

    }

    private void printEndGame(String gameResult) {
        System.out.println(gameResult + " wins!");
    }

    private void printEndOfRound() {
        ui.takeStringInput("Press 666 to continue");
        ui.clearScreen();
    }

    private List<Player> getPlayerList() {
        return playerList;
    }

    private void addRoundCardsToTieCards(List<Card> roundCards) {
        cardsFromTie.addAll(roundCards);
    }

    private void tieAction(Player currentPlayer, Player rivalPlayer, int compareResult, List<Card>roundCards){
        addRoundCardsToTieCards(roundCards);
        currentPlayer.removeTopCard();
        rivalPlayer.removeTopCard();
    }

    private void currentPlayerWinsAction(Player currentPlayer, Player rivalPlayer, int compareResult, List<Card>roundCards) {
        currentPlayer.addRoundCardsToHand(roundCards);
        currentPlayer.removeTopCard();
        rivalPlayer.removeTopCard();
        if (cardsFromTie.size() != 0) {
            currentPlayer.addRoundCardsToHand(roundCards);
            cardsFromTie.clear();
        }
    }

    private void rivalPlayerWinsAction(Player currentPlayer, Player rivalPlayer, int compareResult, List<Card>roundCards) {
        rivalPlayer.addRoundCardsToHand(roundCards);
        currentPlayer.removeTopCard();
        rivalPlayer.removeTopCard();
        if (cardsFromTie.size()!= 0) {
            rivalPlayer.addRoundCardsToHand(roundCards);
            cardsFromTie.clear();
        }
    }
    public void printCard(Card card) {
        String[] headers = {card.getCardName()};
        String[][] data = {{card.attributesToString()}};
        System.out.println(FlipTable.of(headers, data));
    }

    public void askToPrintCard(Player player) {
        Card cardToPrint = player.getTopCard();
        printCard(cardToPrint);
    }

    private void printTable(Player currentPlayer, Player rivalPlayer, boolean isVisibleForAll, boolean isVisibleForOne) {
        Player ai = playerList.get(0);
        if (!isVisibleForAll && isVisibleForOne) {
            if(currentPlayer == ai) {
                System.out.println(xSign);
                askToPrintCard(currentPlayer);
            } else {
                askToPrintCard(currentPlayer);
                System.out.println(xSign);
            }
        } else if (isVisibleForAll && !isVisibleForOne) {
            if (currentPlayer == ai) {
                askToPrintCard(rivalPlayer);
                askToPrintCard(currentPlayer);
            } else {
                askToPrintCard(currentPlayer);
                askToPrintCard(rivalPlayer);
            }
        } else {
            System.out.println(xSign);
            System.out.println(xSign);
        }
    }

    //for later use
//    public void printFourCards(List<Card> listOfCards){
//
//        String[] headers = {listOfCards.get(0).getCardName(),
//                listOfCards.get(1).getCardName(),
//                listOfCards.get(2).getCardName(),
//                listOfCards.get(3).getCardName()};
//
//        String[][] data = {{listOfCards.get(0).attributesToString(),
//                listOfCards.get(1).attributesToString(),
//                listOfCards.get(2).attributesToString(),
//                listOfCards.get(3).attributesToString()}};
//
//        System.out.println(FlipTable.of(headers, data));
//    }
}
