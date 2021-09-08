package com.tictactoe.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToe {

    public String playTurn(int x, int y) {
        return "x..\n...\n...";
    }
}
