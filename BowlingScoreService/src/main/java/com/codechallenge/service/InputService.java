package com.codechallenge.service;

import com.codechallenge.model.Board;
import com.codechallenge.request.SingleThrow;

import java.util.List;

public interface InputService {

    void addSingleThrowToBoard(SingleThrow singleThrow);

    void entireGameInput(List<SingleThrow> allThrows);

    Board getBoard();

}
