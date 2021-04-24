package com.codechallenge.model;

import java.util.LinkedList;

public class Frame {

    private final static Integer TOTAL_PINS = 10;

    private LinkedList<Integer> pinThrows = new LinkedList();
    private boolean isLast = false;
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

    public boolean addPinThrows(Integer pinThrows) {
        if (pinThrows > TOTAL_PINS || (!isLast && (getAllPinThrows() + pinThrows) > TOTAL_PINS)) {
            return false;
        }
        this.pinThrows.add(pinThrows);
        return true;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setAsLast() {
        isLast = true;
    }

    public Integer getScore() {
        if(isLast()) {
            return pinThrows.stream().reduce(0, Integer::sum);
        }
        if(isStrike()) {
            if (this.nextFrame.isLast()) {
                return 10 + this.nextFrame.getPinThrows().get(0) + this.nextFrame.getPinThrows().get(1);
            } else if (this.nextFrame.isStrike()) {
                return 10 + 10 + this.nextFrame.nextFrame.getPinThrows().peekFirst();
            } else {
                return 10 + this.nextFrame.getAllPinThrows();
            }
        } else if (isSpare()){
            return 10 + this.nextFrame.getPinThrows().peekFirst();
        }
        return pinThrows.stream().reduce(0, Integer::sum);
    }

    public boolean isStrike() {
        return pinThrows.peekFirst() == TOTAL_PINS;
    }

    public boolean isSpare() {
        return pinThrows.size() == 2 && pinThrows.stream().reduce(0, Integer::sum).equals(TOTAL_PINS);
    }

    public boolean isClosed() {
        if (pinThrows.isEmpty()) {
            return false;
        }else if (isLast) {
            if (pinThrows.size() < 2 || (pinThrows.peekFirst().equals(TOTAL_PINS) && pinThrows.size() < 3) ||
                    (pinThrows.size() == 2 && pinThrows.stream().reduce(0, Integer::sum).equals(TOTAL_PINS))) {
                return false;
            } else {
                return true;
            }
        } else {
            return pinThrows.stream().reduce(0, Integer::sum).equals(TOTAL_PINS) || pinThrows.size() == 2;
        }
    }

    public Integer getAllPinThrows() {
        return this.pinThrows.stream().reduce(0, Integer::sum);
    }
}
