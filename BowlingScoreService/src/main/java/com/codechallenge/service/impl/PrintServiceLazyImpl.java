package com.codechallenge.service.impl;

import com.codechallenge.builder.FrameScoreBuilder;
import com.codechallenge.builder.PlayerFramesBuilder;
import com.codechallenge.builder.impl.FrameScoreBuilderImpl;
import com.codechallenge.builder.impl.PlayerFramesBuilderImpl;
import com.codechallenge.model.Board;
import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;
import com.codechallenge.service.InputService;
import com.codechallenge.service.OutputService;

/**
 * Lazy implementation of the {@link OutputService} to populate the Board with the result scores at the request for print
 */
public class PrintServiceLazyImpl implements OutputService {

    PlayerFramesBuilder playerFramesBuilder = new PlayerFramesBuilderImpl();
    FrameScoreBuilder frameScoreBuilder = new FrameScoreBuilderImpl();

    @Override
    public String printBoard(Board board){
        this.fillBoard(board);
        StringBuilder boardString = new StringBuilder();
        appendToBoardFrameTitle(boardString);
        board.getPlayers().forEach( player -> appendToBoardSinglePlayer(boardString, player));
        return boardString.toString();
    }

    public Board fillBoard(Board board) {
        if(board.getPlayers().stream().anyMatch(player -> !player.getFrames().isEmpty())) {
            return board;
        }
        board.getPlayers().forEach( player -> playerFramesBuilder.buildFrames(player));
        return board;
    }

    private void appendToBoardFrameTitle(StringBuilder boardString) {
        boardString.append("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        boardString.append(System.getProperty("line.separator"));
    }

    private void appendToBoardSinglePlayer(StringBuilder boardString, Player player) {
        boardString.append(player.getName());
        boardString.append(System.getProperty("line.separator"));
        boardString.append("Pinfalls\t");
        player.getFrames().forEach(frame -> appendToBoardPinFalls(boardString, frame));
        boardString.append(System.getProperty("line.separator"));
        Integer acumScore = 0;
        boardString.append("Score\t\t");
        for (Frame singleFrame : player.getFrames()) {
            acumScore = appendToBoardScore(boardString, singleFrame, acumScore);
        }
        boardString.append(System.getProperty("line.separator"));
    }

    private Integer appendToBoardScore(StringBuilder boardString, Frame frame, Integer acumScore) {
        Integer currentScore = acumScore + frameScoreBuilder.getScore(frame);
        boardString.append(currentScore);
        if (!frame.isLast()) {
            boardString.append("\t\t");
        }
        return currentScore;
    }

    private void appendToBoardPinFalls(StringBuilder boardString, Frame frame) {
        if (frame.isLast()) {
            if (frame.isStrike()) {
                boardString.append("\tX\t");
                String printablePinThrows;
                printablePinThrows = frame.getPinThrows().get(1) == 10 ? "X" : frame.getPinThrows().get(1).toString();
                boardString.append(printablePinThrows + "\t");
                printablePinThrows = frame.getPinThrows().get(2) == 10 ? "X" : frame.getPinThrows().get(2).toString();
                boardString.append(printablePinThrows);
            } else if (frame.isSpare()) {
                boardString.append(frame.getPinThrows().get(0) + "\t");
                boardString.append("/\t");
                boardString.append(frame.getPinThrows().get(2));
            } else {
                if (frame.getPinThrows().get(0) == 0) {
                    boardString.append("F" + "\t");
                    if (frame.getPinThrows().get(1) == 0) {
                        boardString.append("F");
                    } else {
                        boardString.append(frame.getPinThrows().get(1));
                    }
                } else {
                    boardString.append(frame.getPinThrows().get(0) + "\t");
                    boardString.append(frame.getPinThrows().get(1));
                }
            }
        } else if (frame.isStrike()) {
            boardString.append("\tX\t");
        } else if (frame.isSpare()) {
            boardString.append(frame.getPinThrows().get(0) + "\t");
            boardString.append("/\t");
        } else {
            if (frame.getPinThrows().get(0) == 0) {
                boardString.append("F" + "\t");
                if (frame.getPinThrows().get(1) == 0) {
                    boardString.append("F" + "\t");
                } else {
                    boardString.append(frame.getPinThrows().get(1));
                }
            } else {
                boardString.append(frame.getPinThrows().get(0) + "\t");
                boardString.append(frame.getPinThrows().get(1) + "\t");
            }
        }
    }

}
