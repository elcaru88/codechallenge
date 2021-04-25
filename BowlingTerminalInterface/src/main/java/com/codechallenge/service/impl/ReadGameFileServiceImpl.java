package com.codechallenge.service.impl;

import com.codechallenge.model.Board;
import com.codechallenge.request.SingleThrow;
import com.codechallenge.service.InputService;
import com.codechallenge.service.OutputService;
import com.codechallenge.service.ReadGameFileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadGameFileServiceImpl implements ReadGameFileService {

    InputService inputService = new InputServiceLazyImpl();

    OutputService outputService = new PrintServiceLazyImpl();

    @Override
    public Board readFile(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                count++;
                String[] input = line.split(" ");
                Integer pinFalls;
                try {
                    pinFalls = "F".equalsIgnoreCase(input[1]) ? 0 : Integer.parseInt(input[1]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Second argument invalid at line:  " + count);
                }
                if (input.length != 2) {
                    throw new IllegalArgumentException("Invalid number of arguments at line: " + count);
                }
                SingleThrow singleThrow = new SingleThrow(input[0], pinFalls);
                inputService.addSingleThrowToBoard(singleThrow);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputService.getBoard();
    }

    @Override
    public void printResult(Board board) {
        outputService.fillBoard(board);
        System.out.print(outputService.printBoard(board));
    }
}
