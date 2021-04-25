package com.codechallenge.builder;

import com.codechallenge.model.Frame;
import com.codechallenge.model.Player;

public interface PlayerFramesBuilder {

    void buildFrames(Player player);

    void addSingleThrow(Frame frame, Integer pinsFall);
}
