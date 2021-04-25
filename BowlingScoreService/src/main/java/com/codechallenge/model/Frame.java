package com.codechallenge.model;

import java.util.LinkedList;

public class Frame {

    public final static Integer TOTAL_PINS = 10;

    private LinkedList<Integer> pinThrows = new LinkedList();
    private boolean isLast = false;
    private boolean isClosed = false;
    private Frame nextFrame;

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public LinkedList<Integer> getPinThrows() {
        return pinThrows;
    }

    public void addPinThrows(Integer pinThrows) {
        this.pinThrows.add(pinThrows);
    }

    public boolean isLast() {
        return isLast;
    }

    public void setAsLast() {
        isLast = true;
    }

    public boolean isStrike() {
        return pinThrows.peekFirst() == TOTAL_PINS;
    }

    public boolean isSpare() {
        return pinThrows.size() == 2 && getAllPinThrows().equals(TOTAL_PINS);
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
