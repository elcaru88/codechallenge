package com.codechallenge.service.impl;

import com.codechallenge.model.Board;
import com.codechallenge.model.Player;
import com.codechallenge.request.SingleThrow;
import com.codechallenge.service.InputService;

import java.util.List;

public class InputServiceLazyImpl implements InputService {

    private Board board = new Board();

    public void addSingleThrowToBoard(SingleThrow singleThrow) {
        String playerName = singleThrow.getPlayerName();
        Player player = board.getPlayers().stream().filter(singePlayer -> playerName.equals(singePlayer.getName()))
                .findFirst().orElseGet(() -> {
                    Player newPlayer = new Player(playerName);
                    board.getPlayers().add(newPlayer);
                    return newPlayer;
                });
        player.addSingleThrow(singleThrow.getFallPins());
    }

    public void addSingleThrow(String playerName, Integer pinFalls) {
        this.addSingleThrowToBoard(new SingleThrow(playerName, pinFalls));
    }

    public Board getBoard() {
        return board;
    }


    public void entireGameInput(List<SingleThrow> allThrows) {
    }
}
