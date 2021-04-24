package com.codechallenge.service;

import com.codechallenge.model.SingleThrow;

public interface BowlingBoard {

    void addSingleThrow(SingleThrow singleThrow);

    void addSingleThrow(String playerName, Integer pinFalls);

    public void printBoard();

}
