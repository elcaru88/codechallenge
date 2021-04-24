package com.codechallenge.model;

import java.util.LinkedHashSet;

public class Board {

    LinkedHashSet<Player> players;

    public Board () {
        players = new LinkedHashSet<>();
    }

    public LinkedHashSet<Player> getPlayers() {
        return players;
    }
}
