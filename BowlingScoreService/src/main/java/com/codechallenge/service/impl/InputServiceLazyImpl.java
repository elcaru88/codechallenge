package com.codechallenge.service.impl;

import com.codechallenge.model.Board;
import com.codechallenge.model.Player;
import com.codechallenge.request.SingleThrow;
import com.codechallenge.service.InputService;

import java.util.List;

/**
 * Lazy implementation of the {@link InputService} to add the throws done on the game. The score is not calculated at
 * this moment
 */
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

    /**
     * Returns the board with all throws of the players previously added without computing the scores
     * @return instance of {@link Board} with the throws done on the match ready to calculate the scores
     */
    public Board getBoard() {
        return board;
    }

    public void entireGameInput(List<SingleThrow> allThrows) {
        allThrows.forEach(singleThrow -> addSingleThrowToBoard(singleThrow));
    }
}
