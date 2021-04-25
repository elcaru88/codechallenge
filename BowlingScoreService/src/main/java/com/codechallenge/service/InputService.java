package com.codechallenge.service;

import com.codechallenge.model.Board;
import com.codechallenge.request.SingleThrow;

import java.util.List;

public interface InputService {

    /**
     * Adds a single throw of the match to the board
     * @param singleThrow with the name of the player and the amount of pins fallen of the throw
     */
    void addSingleThrowToBoard(SingleThrow singleThrow);

    /**
     * Adds all the throws of an entire match to the board
     * @param allThrows done on the match by all the players
     */
    void entireGameInput(List<SingleThrow> allThrows);

    /**
     * Returns the board with all throws of the players previously added
     * @return instance of {@link Board} with the throws done on the match
     */
    Board getBoard();

}
