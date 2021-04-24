package com.codechallenge;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<String, Player> players = new HashMap<>();

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void printBoard() {
        //print "Frame      1       2       3
        players.forEach((s, player) -> printPlayer(player));
    }

    public void printPlayer(Player player) {
        System.out.println(player.name);
        //print "Jeff"
        System.out.print("Pinfalls");
        System.out.println();
        for (Frame frame : player.getFrames()) {
            System.out.print("    ");
            printPinFalls(frame);
        }
        System.out.println();
        System.out.print("Score");
        System.out.println();
        Integer acum = 0;
        for (Frame frame : player.getFrames()) {
            System.out.print("    ");
            acum += printFrames(frame);
            System.out.print(acum);
        }
    }

    public void printPinFalls(Frame frame) {
        System.out.print(frame);
        //frame.getPointTrhows().forEach(pinFalls -> System.out.print(pinFalls.toString()));
        //System.out.print(frame.);
        //print "Pinfalls       x   4   5   8   /
    }
    public Integer printFrames(Frame frame) {
        return frame.calculateScore();
        //print "Score      20      29      39
    }
}
