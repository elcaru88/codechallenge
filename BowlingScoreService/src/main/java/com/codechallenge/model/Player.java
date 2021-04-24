package com.codechallenge.model;

import java.util.LinkedList;

public class Player {

    private String name;
    private LinkedList<Integer> allThrows;

    public Player(String name) {
        this.name = name;
        allThrows = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Integer> getAllThrows() {
        return allThrows;
    }

    public void addSingleThrow(Integer singleThrow) {
        this.allThrows.add(singleThrow);
    }
}
