package com.codecool.battleofcards;

import java.util.Arrays;

public class Game {
    public UI ui = new UI();

    public void init() {
        NewTable table = new NewTable();
        table.playPVC();
    }
}



