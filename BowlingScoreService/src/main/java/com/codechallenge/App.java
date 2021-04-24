package com.codechallenge;

import com.codechallenge.model.SingleThrow;
import com.codechallenge.service.BowlingBoard;
import com.codechallenge.service.InputService;
import com.codechallenge.service.impl.InputServiceImpl;
import com.codechallenge.service.impl.TraditionalScoreBowlingBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BowlingBoard board = new TraditionalScoreBowlingBoard();
        board.addSingleThrow("Jeff", 3);
        board.addSingleThrow("Jeff", 3);
        board.addSingleThrow("Jeff", 3);
        board.addSingleThrow("Jeff", 7);
        board.addSingleThrow("Jeff", 3);
        board.addSingleThrow("Jeff", 3);
        board.addSingleThrow("Jeff", 11);
        board.addSingleThrow("Jeff", 10);
        board.addSingleThrow("Jeff", 10);
        board.addSingleThrow("Jeff", 0);
        board.addSingleThrow("Jeff", 0);
        board.addSingleThrow("Jeff", 10);
        board.addSingleThrow("Jeff", 10);
        board.addSingleThrow("Jeff", 10);
        board.addSingleThrow("Jeff", 4);
        board.addSingleThrow("Jeff", 5);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.addSingleThrow("John", 10);
        board.printBoard();
        /*InputService inputService = new InputServiceImpl();
        SingleThrow singleThrow = new SingleThrow("Jeff", 3);
        SingleThrow singleThrow1 = new SingleThrow("Jeff", 7);
        SingleThrow singleThrow2 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow3 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow4 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow5 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow6 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow7 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow8 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow9 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow10 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow11 = new SingleThrow("Jeff", 10);
        SingleThrow singleThrow12 = new SingleThrow("Jeff", 10);
        List<SingleThrow> fullGame = new ArrayList<>();
        fullGame.add(singleThrow);
        fullGame.add(singleThrow1);
        fullGame.add(singleThrow2);
        fullGame.add(singleThrow3);
        fullGame.add(singleThrow4);
        fullGame.add(singleThrow5);
        fullGame.add(singleThrow6);
        fullGame.add(singleThrow7);
        fullGame.add(singleThrow8);
        fullGame.add(singleThrow9);
        fullGame.add(singleThrow10);
        fullGame.add(singleThrow11);
        fullGame.add(singleThrow12);
        inputService.entireGameInput(fullGame);*/
    }
}
