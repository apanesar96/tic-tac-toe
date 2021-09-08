package com.tictactoe.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToe {
    char [][] gameBoard = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
    char activePlayer = 'x';

    public String playTurn(int x, int y) throws Exception {
        if(gameBoard[y][x] != '.') {
            throw new Exception("That position is already filled.");
        }
        gameBoard[y][x] = activePlayer;
        changeActivePlayer();
        return printBoard();
    }

    private void changeActivePlayer() {
        activePlayer = activePlayer == 'x' ? 'o' : 'x';
    }

    private String printBoard() {
        StringBuilder boardOutput = new StringBuilder();

        for (char[] row : gameBoard) {
            for (char column : row) {
                boardOutput.append(column);
            }
        }

        return boardOutput.toString();
    }
}
