package com.codechallenge;

import java.util.LinkedList;
import java.util.Map;
import java.util.SortedSet;
import java.util.Stack;

public class Player {

    String name;
    LinkedList<Frame> frames = new LinkedList<>();

    public Player (String name) {
        this.name = name;
    }

    public void makeThrow(Integer pins) {
        //should use last frame or should create a new one
        if (!frames.isEmpty() && !frames.peekLast().isClosed()) {
            frames.peekLast().fallPins(pins);
        } else {
            Frame newFrame = new Frame();
            newFrame.fallPins(pins);
            if (frames.size() == 10) {
                newFrame.makeLast();
            }
            if (!frames.isEmpty()) {
                frames.peekLast().setNextFrame(newFrame);
            }
            frames.push(newFrame);
        }
    }

    public boolean hasFinishTheGame() {
        return frames.size() == 10 && frames.peekLast().isClosed();
    }

    public LinkedList<Frame> getFrames() {
        return this.frames;
    }

}
