package com.codechallenge.service.impl;

import com.codechallenge.builder.FrameScoreBuilder;
import com.codechallenge.builder.PlayerFramesBuilder;
import com.codechallenge.builder.impl.FrameScoreBuilderImpl;
import com.codechallenge.builder.impl.PlayerFramesBuilderImpl;
import com.codechallenge.model.Board;
import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;
import com.codechallenge.service.PrintService;

public class PrintServiceLazyImpl implements PrintService {

    PlayerFramesBuilder playerFramesBuilder = new PlayerFramesBuilderImpl();
    FrameScoreBuilder frameScoreBuilder = new FrameScoreBuilderImpl();

    @Override
    public String printBoard(Board board){
        StringBuilder boardString = new StringBuilder();
        appendToBoardFrameTitle(boardString);
        board.getPlayers().forEach( player -> appendToBoardSinglePlayer(boardString, player));
        return boardString.toString();
    }

    private void appendToBoardFrameTitle(StringBuilder boardString) {
        boardString.append("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        boardString.append(System.getProperty("line.separator"));
    }

    private void appendToBoardSinglePlayer(StringBuilder boardString, Player player) {
        playerFramesBuilder.buildFrames(player);
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
        boardString.append(currentScore + "\t\t");
        return currentScore;
    }

    private void appendToBoardPinFalls(StringBuilder boardString, Frame frame) {
        if (frame.isLast()) {
            if (frame.isStrike()) {
                boardString.append("\tX\t");
                boardString.append(frame.getPinThrows().get(1) + "\t");
                boardString.append(frame.getPinThrows().get(2));
            } else if (frame.isSpare()) {
                boardString.append(frame.getPinThrows().get(0) + "\t");
                boardString.append("/\t");
                boardString.append(frame.getPinThrows().get(2));
            } else {
                boardString.append(frame.getPinThrows().get(0) + "\t");
                boardString.append(frame.getPinThrows().get(1));
            }
        } else if (frame.isStrike()) {
            boardString.append("\tX\t");
        } else if (frame.isSpare()) {
            boardString.append(frame.getPinThrows().get(0) + "\t");
            boardString.append("/\t");
        } else {
            boardString.append(frame.getPinThrows().get(0) + "\t");
            boardString.append(frame.getPinThrows().get(1) + "\t");
        }
    }

}
