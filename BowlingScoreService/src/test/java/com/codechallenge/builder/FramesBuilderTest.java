package com.codechallenge.builder;

import com.codechallenge.builder.impl.PlayerFramesBuilderImpl;
import com.codechallenge.model.Frame;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class FramesBuilderTest {

    PlayerFramesBuilder playerFramesBuilder = new PlayerFramesBuilderImpl();

    @Test (expected = IllegalStateException.class)
    public void testFailClosedFrame() {
        Frame closedFrame = Mockito.mock(Frame.class);
        Mockito.when(closedFrame.isClosed()).thenReturn(Boolean.TRUE);
        playerFramesBuilder.addSingleThrow(closedFrame, 5);
        Assert.fail("Should not add a new throw to a closed frame");
    }

    @Test (expected = IllegalStateException.class)
    public void testFailBiggerNumber() {
        Frame emptyFrame = new Frame();
        playerFramesBuilder.addSingleThrow(emptyFrame, 11);
        Assert.fail("Should not add a throw with a number bigger than MAX_PINES");
    }

    @Test
    public void testStrikeFrame() {
        Frame strikeFrame = new Frame();
        playerFramesBuilder.addSingleThrow(strikeFrame, 10);
        Assert.assertTrue(strikeFrame.isStrike());
    }

    @Test
    public void testSpareFrame() {
        Frame spareFrame = new Frame();
        playerFramesBuilder.addSingleThrow(spareFrame, 3);
        playerFramesBuilder.addSingleThrow(spareFrame, 7);
        Assert.assertTrue(spareFrame.isSpare());
    }

    @Test
    public void testClosedFrame() {
        Frame closedFrame = new Frame();
        playerFramesBuilder.addSingleThrow(closedFrame, 3);
        playerFramesBuilder.addSingleThrow(closedFrame, 3);
        Assert.assertTrue(closedFrame.isClosed());
    }

    @Test
    public void testLastClosedFrame() {
        Frame lastClosedFrame = new Frame();
        lastClosedFrame.setAsLast();
        playerFramesBuilder.addSingleThrow(lastClosedFrame, 3);
        playerFramesBuilder.addSingleThrow(lastClosedFrame, 3);
        Assert.assertTrue(lastClosedFrame.isClosed());
    }



}
