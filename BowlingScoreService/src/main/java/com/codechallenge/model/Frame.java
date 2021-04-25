package com.codechallenge.model;

import java.util.LinkedList;

public class Frame {

    private LinkedList<Integer> pinThrows = new LinkedList();
    private boolean isLast = false;
    private boolean isClosed = false;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private Frame nextFrame;

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public LinkedList<Integer> getPinThrows() {
        return this.pinThrows;
    }

    public void addPinThrows(Integer pinThrows) {
        this.pinThrows.add(pinThrows);
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void setAsLast() {
        this.isLast = true;
    }

    public void setAsStrike() {
        this.isStrike = true;
    }

    public boolean isStrike() {
        return this.isStrike;
    }

    public void setAsSpare() {
        this.isSpare = true;
    }

    public boolean isSpare() {
        return this.isSpare;
    }

    public void close() {
        this.isClosed = true;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public Integer getAllPinThrows() {
        return this.pinThrows.stream().reduce(0, Integer::sum);
    }

    public Integer getSingleThrowPins(int index) {
        return this.getPinThrows().get(index);
    }
}
