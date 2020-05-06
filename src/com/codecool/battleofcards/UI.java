package com.codecool.battleofcards;

import java.util.Scanner;

public class UI {
    private final Scanner scanner = new Scanner(System.in);

    public String takeStringInput(String messageForUser){
        System.out.println(messageForUser);
        return scanner.next();

    }
    public int takeIntegerInput(String messageForUser){
        System.out.print(messageForUser);
        return scanner.nextInt();
    }

    public void printMainMenu() {
        System.out.println("Welcome to Battle of Cards Game. Please choose an option:\n"
                         + "1. New Game\n"
                         + "2. About\n"
                         + "0. Exit");
    }

    public void printAbout(){
        System.out.println("For 2 or more players. The cards are shuffled and dealt. Each player holds his cards so that\n"+
        "only he can see the top card. The player to the left of the dealer reads out any one of the four\n"+
        "specifications on the card i. e. User rating, critics rating, etc. The other players read out the same\n+"+
        "specification from their top cards. The player with the highest value takes the top card from the\n"+
        "other players (including his own), and puts them at the bottom of his cards. That winner then\n"+
        "reads out a specification from his new top card and the game continues. Should any of the\n"+
        "specifications be of the same value the top cards are put to one side, and the winner of the next\n"+
        "round takes those in addition to the hand. The game ends when any player has no cards left,\n"+
        "the winner is the player with most cards.");
    }
    public void printSelectionMenu(){
        System.out.println("Which game mode you want to play ? :\n"
                            +"1. Player vs AI \n"
                            +"2. HotSeat\n"
                            +"3. Custom computer fight");
    }
    public void printSelectNumberOfPlayers(){
        System.out.println("How many Players/AI you wanna play with?");
    }
}

