package com.codechallenge.service;

import com.codechallenge.model.Board;

public interface ReadGameFileService {

    Board readFile(String fileName);

    void printResult(Board board);

}
