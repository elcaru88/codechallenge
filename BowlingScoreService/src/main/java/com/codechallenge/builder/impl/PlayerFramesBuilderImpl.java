package com.codechallenge.builder.impl;

import com.codechallenge.builder.PlayerFramesBuilder;
import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;

import java.util.LinkedList;

/**
 * Implementation of {@link PlayerFramesBuilder} to build the Frame considering that the total pins are 10 and the total
 * frames are 10.
 */
public class PlayerFramesBuilderImpl implements PlayerFramesBuilder {

    private static Integer TOTAL_FRAMES = 10;
    public final static Integer TOTAL_PINS = 10;

    public void buildFrames(Player player) {
        Frame currentFrame = new Frame();
        player.getFrames().push(currentFrame);
        LinkedList<Integer> allThrows = player.getAllThrows();
        for (Integer pinFalls : allThrows) {
            if (currentFrame.isClosed() && !currentFrame.isLast()) {
                currentFrame.setNextFrame(new Frame());
                currentFrame = currentFrame.getNextFrame();
                player.getFrames().add(currentFrame);
                if (player.getFrames().size() == TOTAL_FRAMES) {
                    currentFrame.setAsLast();
                }
            } else if (currentFrame.isClosed() && currentFrame.isLast()) {
                throw new IllegalStateException("Player " + player.getName() + " finished his frames and tried to continue");
            }
            addSingleThrow(currentFrame, pinFalls);
        }
        if (player.getFrames().size() < TOTAL_FRAMES ||
                player.getFrames().stream().anyMatch(singleStream -> !singleStream.isClosed())) {
            throw new IllegalStateException("Player " + player.getName() + " didn't finish his frames");
        }
    }

    public void addSingleThrow(Frame frame, Integer pinsFall) {
        if (frame.isClosed()) {
            throw new IllegalStateException("Trying to add a throw to a closed frame");
        }
        frame.addPinThrows(pinsFall);
        int pinThrowsSize = frame.getPinThrows().size();
        if (pinThrowsSize == 1 && pinsFall == TOTAL_PINS){
            frame.setAsStrike();
        }
        if (pinThrowsSize == 2 && frame.getAllPinThrows() == TOTAL_PINS){
            frame.setAsSpare();
        }
        if (!frame.isLast() && (frame.getAllPinThrows().equals(TOTAL_PINS) || pinThrowsSize == 2)) {
            frame.close();
        }
        if (frame.isLast() && (pinThrowsSize == 3 || (pinThrowsSize == 2 && frame.getAllPinThrows() < TOTAL_PINS) )) {
            frame.close();
        }
    }
}
