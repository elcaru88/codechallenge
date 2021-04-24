package com.codechallenge;

import com.codechallenge.model.Board;
import com.codechallenge.service.impl.InputServiceImpl;
import com.codechallenge.service.impl.PrintServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        InputServiceImpl inputService = new InputServiceImpl();
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
        Board board = inputService.getBoard();
        PrintServiceImpl printService = new PrintServiceImpl();
        System.out.print(printService.printBoard(board));
    }
}
