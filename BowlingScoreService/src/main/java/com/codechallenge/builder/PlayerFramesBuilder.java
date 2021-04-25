package com.codechallenge.builder;

import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;

/**
 * A {@link Player} has a List of {@link Frame} that is calculated from its List of {@link com.codechallenge.request.SingleThrow}.
 */
public interface PlayerFramesBuilder {

    /**
     * Builds the frames for a determined played, should be called once all the single throws of the player has been
     * added
     * @param player to build the frames
     */
    void buildFrames(Player player);

    /**
     * Add a single throw to a Frame and close the frame when needed
     * @param frame open Frame to add the single throw
     * @param pinsFall amount of pins fallen by the single throw
     */
    void addSingleThrow(Frame frame, Integer pinsFall);
}
