package com.codechallenge;

import com.codechallenge.model.Board;
import com.codechallenge.service.OutputService;
import com.codechallenge.service.impl.InputServiceLazyImpl;
import com.codechallenge.service.impl.PrintServiceLazyImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        InputServiceLazyImpl inputService = new InputServiceLazyImpl();
        inputService.addSingleThrow("Jeff", 3);
        inputService.addSingleThrow("Jeff", 3);
        inputService.addSingleThrow("Jeff", 3);
        inputService.addSingleThrow("Jeff", 7);
        inputService.addSingleThrow("Jeff", 3);
        inputService.addSingleThrow("Jeff", 3);
        inputService.addSingleThrow("Jeff", 11);
        inputService.addSingleThrow("Jeff", 10);
        inputService.addSingleThrow("Jeff", 10);
        inputService.addSingleThrow("Jeff", 0);
        inputService.addSingleThrow("Jeff", 0);
        inputService.addSingleThrow("Jeff", 10);
        inputService.addSingleThrow("Jeff", 10);
        inputService.addSingleThrow("Jeff", 10);
        inputService.addSingleThrow("Jeff", 4);
        inputService.addSingleThrow("Jeff", 5);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        inputService.addSingleThrow("John", 10);
        Board board = inputService.getBoard();
        OutputService outputService = new PrintServiceLazyImpl();
        outputService.fillBoard(board);
        System.out.print(outputService.printBoard(board));
    }
}
