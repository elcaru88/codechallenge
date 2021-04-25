package com.codechallenge.builder.impl;

import com.codechallenge.builder.PlayerFramesBuilder;
import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;

import java.util.LinkedList;

import static com.codechallenge.model.Frame.TOTAL_PINS;

public class PlayerFramesBuilderImpl implements PlayerFramesBuilder {

    public void buildFrames(Player player) {
        Frame currentFrame = new Frame();
        player.getFrames().push(currentFrame);
        LinkedList<Integer> allThrows = player.getAllThrows();
        for (Integer pinFalls : allThrows) {
            if (currentFrame.isClosed() && !currentFrame.isLast()) {
                currentFrame.setNextFrame(new Frame());
                currentFrame = currentFrame.getNextFrame();
                if (player.getFrames().size() == 9) {
                    currentFrame.setAsLast();
                }
                player.getFrames().add(currentFrame);
            }
            addSingleThrow(currentFrame, pinFalls);
        }
    }

    public void addSingleThrow(Frame frame, Integer pinsFall) {
        if (frame.isClosed()) {
            return;
        }
        frame.addPinThrows(pinsFall);
        int pinThrowsSize = frame.getPinThrows().size();
        if (!frame.isLast() && (frame.getAllPinThrows().equals(TOTAL_PINS) || pinThrowsSize == 2)) {
            frame.close();
        }
        if (frame.isLast() && (pinThrowsSize == 3 || (pinThrowsSize == 2 && frame.getAllPinThrows() < TOTAL_PINS) )) {
            frame.close();
        }
    }
}
