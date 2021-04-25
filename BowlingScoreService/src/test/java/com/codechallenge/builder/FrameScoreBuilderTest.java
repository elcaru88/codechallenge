package com.codechallenge.builder;

import com.codechallenge.builder.impl.FrameScoreBuilderImpl;
import com.codechallenge.model.Frame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.LinkedList;

public class FrameScoreBuilderTest {

    Frame mockedLessThanTen = Mockito.mock(Frame.class);
    Frame mockedStrike = Mockito.mock(Frame.class);
    Frame mockedSpare = Mockito.mock(Frame.class);
    Frame mockedLessThanTenLast = Mockito.mock(Frame.class);
    Frame mockedStrikeLast = Mockito.mock(Frame.class);
    Frame mockedSpareLast = Mockito.mock(Frame.class);

    LinkedList<Integer> pinThrowsLessThanTen = new LinkedList<>();
    LinkedList<Integer> pinThrowsStrike = new LinkedList<>();
    LinkedList<Integer> pinThrowsSpare = new LinkedList<>();
    LinkedList<Integer> pinThrowsLessThanTenLast = new LinkedList<>();
    LinkedList<Integer> pinThrowsStrikeLast = new LinkedList<>();
    LinkedList<Integer> pinThrowsSpareLast = new LinkedList<>();


    FrameScoreBuilderImpl builder = new FrameScoreBuilderImpl();

    @Test
    public void testLessThanTen() {
        Assert.assertEquals(Integer.valueOf(8), builder.getScore(mockedLessThanTen));
    }

    @Test
    public void testStrike() {
        Mockito.when(mockedStrike.getNextFrame()).thenReturn(mockedLessThanTen);
        Assert.assertEquals(Integer.valueOf(10 + builder.getScore(mockedLessThanTen)), builder.getScore(mockedStrike));
    }

    @Test
    public void testSpare() {
        Mockito.when(mockedSpare.getNextFrame()).thenReturn(mockedLessThanTen);
        Assert.assertEquals(Integer.valueOf(10 + mockedLessThanTen.getPinThrows().get(0)), builder.getScore(mockedSpare));
    }

    @Test
    public void testLessThanTenLast() {
        Assert.assertEquals(Integer.valueOf(7), builder.getScore(mockedLessThanTenLast));
    }

    @Test
    public void testStrikeLast() {
        Assert.assertEquals(Integer.valueOf(23), builder.getScore(mockedStrikeLast));
    }

    @Test
    public void testSpareLast() {
        Assert.assertEquals(Integer.valueOf(15), builder.getScore(mockedSpareLast));
    }

    @Test
    public void testFail() {
        Frame failFrame = Mockito.mock(Frame.class);
        LinkedList<Integer> failThrow = new LinkedList<>();
        failThrow.add(11);
        configureFrameWithPin(failFrame, failThrow);
        Mockito.when(failFrame.isStrike()).thenReturn(Boolean.FALSE);
        Mockito.when(failFrame.isSpare()).thenReturn(Boolean.FALSE);
        System.out.print(builder.getScore(failFrame));
    }


    @Before
    public void configureMockedFrames(){
        preparePinThrows();
        configureFrameWithPin(mockedLessThanTen, pinThrowsLessThanTen);
        configureFrameWithPin(mockedStrike, pinThrowsStrike);
        configureFrameWithPin(mockedSpare, pinThrowsSpare);
        configureFrameWithPin(mockedLessThanTenLast, pinThrowsLessThanTenLast);
        configureFrameWithPin(mockedStrikeLast, pinThrowsStrikeLast);
        configureFrameWithPin(mockedSpareLast, pinThrowsSpareLast);
        configureLastFrame(new Frame[]{mockedLessThanTenLast, mockedStrikeLast, mockedSpareLast});
        configureNotLastFrame(new Frame[]{mockedLessThanTen, mockedStrike, mockedSpare});
        configureOpenFrames(new Frame[]{mockedLessThanTen, mockedLessThanTenLast});
        configureStrikeFrames(new Frame[]{mockedStrike, mockedStrikeLast});
        configureSpareFrames(new Frame[]{mockedSpare, mockedSpareLast});
    }

    private void preparePinThrows() {
        pinThrowsLessThanTen.add(3);
        pinThrowsLessThanTen.add(5);
        pinThrowsStrike.add(10);
        pinThrowsSpare.add(6);
        pinThrowsSpare.add(4);
        pinThrowsLessThanTenLast.add(2);
        pinThrowsLessThanTenLast.add(5);
        pinThrowsStrikeLast.add(10);
        pinThrowsStrikeLast.add(5);
        pinThrowsStrikeLast.add(8);
        pinThrowsSpareLast.add(3);
        pinThrowsSpareLast.add(7);
        pinThrowsSpareLast.add(5);
    }

    private void configureFrameWithPin(Frame frame, LinkedList<Integer> pins){
        Mockito.when(frame.getPinThrows()).thenReturn(pins);
        Mockito.when(frame.getAllPinThrows()).thenCallRealMethod();
        Mockito.when(frame.getSingleThrowPins(Mockito.any(Integer.class))).thenCallRealMethod();
    }

    private void configureLastFrame(Frame[] frames) {
        Arrays.stream(frames).forEach(frame -> Mockito.when(frame.isLast()).thenReturn(Boolean.TRUE));
    }

    private void configureNotLastFrame(Frame[] frames) {
        Arrays.stream(frames).forEach(frame -> Mockito.when(frame.isLast()).thenReturn(Boolean.FALSE));
    }

    private void configureOpenFrames(Frame[] frames) {
        Arrays.stream(frames).forEach(frame -> {
            Mockito.when(frame.isStrike()).thenReturn(Boolean.FALSE);
            Mockito.when(frame.isSpare()).thenReturn(Boolean.FALSE);
        });
    }

    private void configureStrikeFrames(Frame[] frames) {
        Arrays.stream(frames).forEach(frame -> {
            Mockito.when(frame.isStrike()).thenReturn(Boolean.TRUE);
            Mockito.when(frame.isSpare()).thenReturn(Boolean.FALSE);
        });
    }

    private void configureSpareFrames(Frame[] frames) {
        Arrays.stream(frames).forEach(frame -> {
            Mockito.when(frame.isStrike()).thenReturn(Boolean.FALSE);
            Mockito.when(frame.isSpare()).thenReturn(Boolean.TRUE);
        });
    }
}
