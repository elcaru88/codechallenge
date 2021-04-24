package com.codechallenge.model;

public class SingleThrow {

    private String playerName;

    private Integer fallPins;

    public SingleThrow(String playerName, Integer fallPins) {
        this.playerName = playerName;
        this.fallPins = fallPins;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getFallPins() {
        return fallPins;
    }

    public void setFallPins(Integer fallPins) {
        this.fallPins = fallPins;
    }
}
