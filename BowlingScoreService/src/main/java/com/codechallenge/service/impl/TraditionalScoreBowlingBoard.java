package com.codechallenge.service.impl;

import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;
import com.codechallenge.model.SingleThrow;
import com.codechallenge.service.BowlingBoard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TraditionalScoreBowlingBoard implements BowlingBoard {

    private Map<String, Player> players = new HashMap<>();

    public void addSingleThrow(SingleThrow singleThrow) {
        Player player = players.computeIfAbsent(singleThrow.getPlayerName(), name -> new Player(name));
        player.addSingleThrow(singleThrow.getFallPins());
        /*Frame currentFrame = player.getAllThrows().peekLast();
        currentFrame = currentFrame.isClosed() ? new Frame() : currentFrame;
        if (player.getAllThrows().size() == 10 && !currentFrame.isLast()) {
            currentFrame.setAsLast();
        }
        currentFrame.addPinThrows(singleThrow.getFallPins());*/
    }

    public void addSingleThrow(String playerName, Integer pinFalls) {
        addSingleThrow(new SingleThrow(playerName, pinFalls));
    }


    private LinkedList<Frame> buildFrames(Player player) throws Exception {
        LinkedList<Frame> frames = new LinkedList<>();
        Frame currentFrame = new Frame();
        frames.push(currentFrame);
        LinkedList<Integer> allThrows = player.getAllThrows();
        for (Integer pinFalls : allThrows) {
            if (currentFrame.isClosed() && !currentFrame.isLast()) {
                currentFrame.setNextFrame(new Frame());
                currentFrame = currentFrame.getNextFrame();
                if (frames.size() == 9) {
                    currentFrame.setAsLast();
                }
                frames.add(currentFrame);
            }
            if (!currentFrame.addPinThrows(pinFalls)) {
                throw new Exception("Invalid");
            }
        }
        return frames;
    }

    private void printPlayerScore(String playerName, LinkedList<Frame> frames) {
        System.out.println();
        System.out.println(playerName);
        System.out.print("Pinfalls  ");
        frames.forEach(frame -> printSingleFrames(frame));
        System.out.println();
        System.out.print("Score     ");
        Integer acum = 0;
        for (Frame singleFrame : frames) {
            acum = printSingeScore(singleFrame, acum);
        }
    }

    private Integer printSingeScore(Frame singleFrame, Integer acum) {
        acum = singleFrame.getScore() + acum;
        System.out.print(acum + "     ");
        return acum;
    }

    private void printSingleFrames(Frame singleFrame) {
        if (singleFrame.isLast()) {
            if (singleFrame.isStrike()) {
                System.out.print("  X  " + singleFrame.getPinThrows().get(1) + "  " + singleFrame.getPinThrows().get(2));
            } else if (singleFrame.isSpare()) {
                System.out.print(singleFrame.getPinThrows().peekFirst() + "  /   " + singleFrame.getPinThrows().get(2));
            } else {
                System.out.print(singleFrame.getPinThrows().peekFirst() + "   " + singleFrame.getPinThrows().get(1));
            }
        } else if (singleFrame.isStrike()) {
            System.out.print("  X  ");
        } else if (singleFrame.isSpare()) {
            System.out.print(singleFrame.getPinThrows().peekFirst() + "  /");
        } else {
            System.out.print(singleFrame.getPinThrows().peekFirst() + "  " + singleFrame.getPinThrows().get(1) + "  ");
        }
    }

    public void printBoard() {
        System.out.print("Frame     1     2     3     4     5     6     7     8     9     10");
        players.forEach((playerName, player) -> {
            try {
                printPlayerScore(playerName, buildFrames(player));
            } catch (Exception e) {
                System.out.print("INVALID FRAME");
            }
        });
    }

}
