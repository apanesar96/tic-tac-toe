package com.tictactoe.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TicTacToeShould {

	private TicTacToe target;

	@BeforeEach
	void setUp() {
		target = new TicTacToe();
	}

	@Test
	void place_x_in_top_left() {
		assertEquals("x..\n...\n...", target.playTurn(0, 0));
	}

	@Test
	void name() {
		
	}
}
