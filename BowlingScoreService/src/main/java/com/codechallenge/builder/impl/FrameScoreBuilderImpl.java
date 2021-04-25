package com.codechallenge.builder.impl;

import com.codechallenge.builder.FrameScoreBuilder;
import com.codechallenge.model.Frame;

import static com.codechallenge.builder.impl.PlayerFramesBuilderImpl.TOTAL_PINS;


/**
 * Implementation of {@link FrameScoreBuilder} to calculate the score of a frame considering the traditional scoring
 * rules.
 *
 * @see <a href="https://www.youtube.com/watch?v=aBe71sD8o8c">Traditional scoring rule explination video</a>
 */
public class FrameScoreBuilderImpl implements FrameScoreBuilder {

    public Integer getScore(Frame frame) {
        //TODO: fail if a frame has a throw with more than TOTAL_PINS on one try
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
