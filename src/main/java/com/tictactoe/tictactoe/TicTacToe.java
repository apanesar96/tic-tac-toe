package com.tictactoe.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class TicTacToe {
    char [][] gameBoard = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
    char activePlayer = 'x';

    public String playTurn(int x, int y) throws Exception {
        if (!isPositionAvailable(x, y)) throw new Exception("That position is already filled.");

        gameBoard[y][x] = activePlayer;

        if (isTie()) return "Tie";

        changeActivePlayer();

        return printBoard();
    }

    private boolean isTie() {
        boolean isTie = true;

        for ( char[] row : gameBoard) {
            for (char column : row) {
                if(column == '.'){
                    isTie = false;

                    break;
                }
            }
        }

        return isTie;
    }

    private boolean isPositionAvailable(int x, int y) {
       return gameBoard[y][x] == '.';
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
