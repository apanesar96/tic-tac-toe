package com.tictactoe.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TicTacToeShould {
	private TicTacToe target;

	@BeforeEach
	void setUp() {
		target = new TicTacToe();
	}

	@Test
	void place_x_in_top_left() throws Exception {

		//Then
		assertEquals("x........", target.playTurn(0, 0));
	}

	@Test
	void place_x_in_top_right() throws Exception {

		//Then
		assertEquals("..x......", target.playTurn(2, 0));
	}

	@Test
	void place_x_in_center() throws Exception {

		//Then
		assertEquals("....x....", target.playTurn(1, 1));
	}

	@Test
	void after_player_one_turn_it_is_player_twos_turn() throws Exception {
		//When
		target.playTurn(0,0);

		//Then
		assertEquals("x...o....", target.playTurn(1,1));
	}

	@Test
	void not_overwrite_a_filled_position() throws Exception {
		//when
		target.playTurn(0,0);

		//then
		Exception exception = assertThrows(Exception.class, () -> {
			target.playTurn(0,0);
		});

		assertEquals(exception.getMessage(), "That position is already filled.");
	}

	@Test
	void check_if_game_is_a_tie() throws Exception {
		//given
		target.playTurn(0,0); // X
		target.playTurn(2,0); // 0
		target.playTurn(1,0); // X

		target.playTurn(0,1); // 0
		target.playTurn(2,1); // X
		target.playTurn(1,1); // 0

		target.playTurn(0,2); // X
		target.playTurn(2,2); // 0

		// when
		String result = target.playTurn(1,2);

		assertEquals("Tie", result);
	}
}
