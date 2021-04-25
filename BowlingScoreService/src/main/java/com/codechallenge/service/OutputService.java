package com.codechallenge.service;

import com.codechallenge.model.Board;

public interface OutputService {

    /**
     * Prettifies the board and converts it to a {@link String}
     * @param board to be prettified
     * @return a representation of the board as a String
     */
    String printBoard(Board board);

}
