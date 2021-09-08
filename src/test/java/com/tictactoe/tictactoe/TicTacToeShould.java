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
		//When
		target.playTurn(0, 0);

		//Then
		assertEquals("x........", target.printBoard());
	}

	@Test
	void place_x_in_top_right() {
		//When
		target.playTurn(2, 0);

		//Then
		assertEquals("..x......", target.printBoard());
	}

	@Test
	void place_x_in_center() {
		//When
		target.playTurn(1, 1);

		//Then
		assertEquals("....x....", target.printBoard());
	}
}
