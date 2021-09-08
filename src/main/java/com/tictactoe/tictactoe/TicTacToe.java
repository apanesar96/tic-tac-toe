package com.tictactoe.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class TicTacToe {

    private char activePlayer = 'x';
    private Board gameBoard = new Board();

    public String playTurn(Position position) throws Exception {
        gameBoard.placeToken(position, activePlayer);

        if (gameBoard.isTie()) return "Tie";

        changeActivePlayer();

        return gameBoard.printBoard();
    }

    private void changeActivePlayer() {
        activePlayer = activePlayer == 'x' ? 'o' : 'x';
    }

}
