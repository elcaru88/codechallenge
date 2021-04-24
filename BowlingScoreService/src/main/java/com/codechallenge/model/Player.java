package com.codechallenge.model;

import java.util.LinkedList;

public class Player {

    private String name;
    private LinkedList<Integer> allThrows;
    private LinkedList<Frame> frames;

    public Player(String name) {
        this.name = name;
        allThrows = new LinkedList<>();
        frames = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Integer> getAllThrows() {
        return allThrows;
    }

    public void addSingleThrow(Integer singleThrow) {
        this.allThrows.add(singleThrow);
    }

    public LinkedList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(LinkedList<Frame> frames) {
        this.frames = frames;
    }

    public void buildFrames() {
        Frame currentFrame = new Frame();
        this.frames.push(currentFrame);
        LinkedList<Integer> allThrows = this.getAllThrows();
        for (Integer pinFalls : allThrows) {
            if (currentFrame.isClosed() && !currentFrame.isLast()) {
                currentFrame.setNextFrame(new Frame());
                currentFrame = currentFrame.getNextFrame();
                if (this.frames.size() == 9) {
                    currentFrame.setAsLast();
                }
                frames.add(currentFrame);
            }
            if (!currentFrame.addPinThrows(pinFalls)) {
                System.out.println("FAILED");
            }
        }
    }
}
