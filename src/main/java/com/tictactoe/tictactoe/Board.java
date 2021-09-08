package com.tictactoe.tictactoe;

public class Board {

    char [][] gameBoard = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};

    public String printBoard() {
        StringBuilder boardOutput = new StringBuilder();

        for (char[] row : gameBoard) {
            for (char column : row) {
                boardOutput.append(column);
            }
        }

        return boardOutput.toString();
    }

    public void placeToken(Position position, char activePlayer) {
        int x = position.x;
        int y = position.y;
        gameBoard[y][x] = activePlayer;
    }
}
