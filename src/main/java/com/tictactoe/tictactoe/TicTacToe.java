package com.tictactoe.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToe {
    char [][] gameBoard = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};

    public void playTurn(int x, int y) {
        gameBoard[y][x] = 'x';
    }

    public String printBoard() {
        String boardOutput = "";

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                boardOutput += gameBoard[i][j];
            }
        }

        return boardOutput;
    }
}
