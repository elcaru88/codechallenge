package com.codechallenge;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Integer> pointTrhows = new ArrayList();
    private boolean isLast;
    private Frame nextFrame;

    public void makeLast() {
        this.isLast = true;
    }

    public List<Integer> getPointTrhows() {
        return this.pointTrhows;
    }

    /**
     *
     * @param fallPins
     */
    public void fallPins(Integer fallPins) {
        pointTrhows.add(fallPins);
    }

    public boolean isStrike() {
        return pointTrhows.stream().reduce(0, Integer::sum) == 10 && pointTrhows.size() == 1;
    }

    public boolean isSpare() {
        return pointTrhows.stream().reduce(0, Integer::sum) == 10 && pointTrhows.size() == 2;
    }

    public boolean isClosed() {
        if (isLast) {
            if (pointTrhows.isEmpty() || pointTrhows.size() < 2 || (pointTrhows.get(0) == 10 && pointTrhows.size() <= 2) ||
                    (pointTrhows.size() == 2 && pointTrhows.stream().reduce(0, Integer::sum) == 10)) {
                return false;
            } else {
                return true;
            }
            //special case
        } else {
            return pointTrhows.stream().reduce(0, Integer::sum) == 10 || pointTrhows.size() == 2;
        }
    }

    @Override
    public String toString() {
        if (this.isStrike()) {
            return "    X";
        } else if (this.isSpare()){
            return this.getPointTrhows().get(0) + "  //";
        } else{
            return this.getPointTrhows().get(0) + "   " + this.getPointTrhows().get(1);
        }
    }

    public Integer calculateScore(){
        if (this.isLast) {
            return 10 + pointTrhows.stream().reduce(0, Integer::sum);
        }
        if (this.isStrike()) {
            if (this.nextFrame.getPointTrhows().size() == 1) {
                return 10 + this.nextFrame.getPointTrhows().get(0) + this.nextFrame.getNextFrame().getPointTrhows().get(0);
            } else if (this.nextFrame.getPointTrhows().size() == 2) {
                return 10 + this.nextFrame.getPointTrhows().get(0) + this.nextFrame.getPointTrhows().get(1);
            } else {
                return null;
            }
        } else if (this.isSpare()) {
            return 10 + this.nextFrame.getPointTrhows().get(0);
        } else {
            return this.getPointTrhows().get(0) + this.getPointTrhows().get(1);
        }
    }

    public Frame getNextFrame() {
        return this.nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }
}
