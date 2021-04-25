package com.codechallenge.builder;

import com.codechallenge.model.Frame;

/**
 * The score of each frame is determined by the rules of the game. Implement this interface with and apply the logic
 * to comply with the desired scoring rule.
 */
public interface FrameScoreBuilder {

    /**
     * Returns the calculated score for a frame
     * @param frame to be scored
     * @return the calculated score
     */
    Integer getScore(Frame frame);
}
