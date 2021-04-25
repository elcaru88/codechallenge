package com.codechallenge.builder.impl;

import com.codechallenge.builder.FrameScoreBuilder;
import com.codechallenge.model.Frame;

import static com.codechallenge.model.Frame.TOTAL_PINS;

public class FrameScoreBuilderImpl implements FrameScoreBuilder {

    public Integer getScore(Frame frame) {
        if(frame.isLast()) {
            return frame.getAllPinThrows();
        }
        if(frame.isStrike()) {
            if (frame.getNextFrame().isLast()) {
                return TOTAL_PINS + frame.getNextFrame().getSingleThrowPins(0) + frame.getNextFrame().getSingleThrowPins(1);
            } else if (frame.getNextFrame().isStrike()) {
                return TOTAL_PINS + TOTAL_PINS + frame.getNextFrame().getNextFrame().getSingleThrowPins(0);
            } else {
                return TOTAL_PINS + frame.getNextFrame().getAllPinThrows();
            }
        } else if (frame.isSpare()){
            return TOTAL_PINS + frame.getNextFrame().getSingleThrowPins(0);
        }
        return frame.getAllPinThrows();
    }
}
