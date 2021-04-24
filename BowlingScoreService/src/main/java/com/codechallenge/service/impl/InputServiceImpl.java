package com.codechallenge.service.impl;

import com.codechallenge.Board;
import com.codechallenge.Player;
import com.codechallenge.model.SingleThrow;
import com.codechallenge.service.InputService;

import java.util.List;
import java.util.Map;

public class InputServiceImpl implements InputService {

    public void executeSingleThrow(SingleThrow singleThrow, Board board) {
        Map<String, Player> players = board.getPlayers();
        Player player;
        if (players.containsKey(singleThrow.getPlayerName())) {
            player = players.get(singleThrow.getPlayerName());
        } else {
            player = new Player(singleThrow.getPlayerName());
            players.put(singleThrow.getPlayerName(), player);
        }
        player.makeThrow(singleThrow.getFallPins());
    }

    public void entireGameInput(List<SingleThrow> allThrows) {
        Board board = new Board();
        allThrows.forEach(singleThrow -> executeSingleThrow(singleThrow, board));
        board.printBoard();
    }
}
