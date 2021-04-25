package com.codechallenge.executable;

import com.codechallenge.model.Board;
import com.codechallenge.service.OutputService;
import com.codechallenge.service.ReadGameFileService;
import com.codechallenge.service.impl.PrintServiceLazyImpl;
import com.codechallenge.service.impl.ReadGameFileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IntegrationTest {

    @Test
    public void twoPlayersGame() throws IOException {
        ReadGameFileService readGameFileService = new ReadGameFileServiceImpl();
        Board board = readGameFileService.readFile("src/test/resources/twoplayers");
        String result = new String(Files.readAllBytes(Paths.get("src/test/resources/twoplayers.result")));
        OutputService outputService = new PrintServiceLazyImpl();
        Assert.assertEquals(result, outputService.printBoard(board));
    }

    @Test
    public void onePlayerPerfectGame() throws IOException {
        ReadGameFileService readGameFileService = new ReadGameFileServiceImpl();
        Board board = readGameFileService.readFile("src/test/resources/oneplayerperfectgame");
        String result = new String(Files.readAllBytes(Paths.get("src/test/resources/oneplayerperfectgame.result")));
        OutputService outputService = new PrintServiceLazyImpl();
        Assert.assertEquals(result, outputService.printBoard(board));
    }

    @Test
    public void onePlayerZeroScore() throws IOException {
        ReadGameFileService readGameFileService = new ReadGameFileServiceImpl();
        Board board = readGameFileService.readFile("src/test/resources/oneplayerzeroscore");
        String result = new String(Files.readAllBytes(Paths.get("src/test/resources/oneplayerzeroscore.result")));
        OutputService outputService = new PrintServiceLazyImpl();
        Assert.assertEquals(result, outputService.printBoard(board));
    }
}
