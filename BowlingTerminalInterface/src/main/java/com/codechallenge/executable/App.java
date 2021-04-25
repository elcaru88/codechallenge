package com.codechallenge.executable;

import com.codechallenge.model.Board;
import com.codechallenge.service.ReadGameFileService;
import com.codechallenge.service.impl.ReadGameFileServiceImpl;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid filaName argument");
        }
        ReadGameFileService readGameFileService = new ReadGameFileServiceImpl();
        Board board = readGameFileService.readFile(args[0]);
        readGameFileService.printResult(board);
    }
}
