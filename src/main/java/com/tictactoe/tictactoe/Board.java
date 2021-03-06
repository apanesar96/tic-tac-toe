package com.tictactoe.tictactoe;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Arrays;

public class Board {

    private char [][] gameBoard = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};

    public String printBoard() {
        StringBuilder boardOutput = new StringBuilder();

        for (char[] row : gameBoard) {
            for (char column : row) {
                boardOutput.append(column);
            }
        }

        return boardOutput.toString();
    }

    public void placeToken(Position position, char activePlayer) throws Exception {
        if (!isPositionAvailable(position)) throw new Exception("That position is already filled.");
        int x = position.x;
        int y = position.y;
        gameBoard[y][x] = activePlayer;
    }

    public boolean isTie() {
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

    public boolean isAWin(char activePlayer) {
        boolean isAWin = false;

        char [] winning = {activePlayer, activePlayer, activePlayer};

        for (char[] row : gameBoard) {
            if(Arrays.equals(row, winning)) isAWin = true;
        }

        return isAWin;
    }
}
