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
        if (!isPositionAvailable(position)) throw new Exception("That position is already filled.");

        gameBoard.placeToken(position, activePlayer);

        if (isTie()) return "Tie";

        changeActivePlayer();

        return gameBoard.printBoard();
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

    private boolean isPositionAvailable(Position position) {
       return gameBoard[position.y][position.x] == '.';
    }

    private void changeActivePlayer() {
        activePlayer = activePlayer == 'x' ? 'o' : 'x';
    }

}
