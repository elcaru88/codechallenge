package com.codechallenge.builder;

import com.codechallenge.builder.impl.PlayerFramesBuilderImpl;
import com.codechallenge.model.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerBuilderTest {

    PlayerFramesBuilder playerFramesBuilder = new PlayerFramesBuilderImpl();

    @Test (expected = IllegalStateException.class)
    public void testFailUnfinishedPlayer() {
        Player player = new Player("Unifinished");
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        playerFramesBuilder.buildFrames(player);
        Assert.fail("The player should finish all his frames to calculate the score");
    }

    @Test (expected = IllegalStateException.class)
    public void testFailContinuePlayingPlayer() {
        Player player = new Player("Unifinished");
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        player.addSingleThrow(10);
        playerFramesBuilder.buildFrames(player);
        Assert.fail("The player should not continue throwing after finishing all his frames");
    }
}
