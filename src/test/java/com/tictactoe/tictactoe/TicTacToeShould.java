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
		assertEquals("x........", target.playTurn(new Position(0,0)));
	}

	@Test
	void place_x_in_top_right() throws Exception {

		//Then
		assertEquals("..x......", target.playTurn(new Position(2,0)));
	}

	@Test
	void place_x_in_center() throws Exception {

		//Then
		assertEquals("....x....", target.playTurn(new Position(1,1)));
	}

	@Test
	void after_player_one_turn_it_is_player_twos_turn() throws Exception {
		//When
		target.playTurn(new Position(0,0));

		//Then
		assertEquals("x...o....", target.playTurn(new Position(1,1)));
	}

	@Test
	void not_overwrite_a_filled_position() throws Exception {
		//when
		target.playTurn(new Position(0,0));

		//then
		Exception exception = assertThrows(Exception.class, () -> {
			target.playTurn(new Position(0,0));
		});

		assertEquals(exception.getMessage(), "That position is already filled.");
	}

	@Test
	void check_if_game_is_a_tie() throws Exception {
		//given
		target.playTurn(new Position(0,0)); // X
		target.playTurn(new Position(2,0)); // 0
		target.playTurn(new Position(1,0)); // X

		target.playTurn(new Position(0,1)); // 0
		target.playTurn(new Position(2,1)); // X
		target.playTurn(new Position(1,1)); // 0

		target.playTurn(new Position(0,2)); // X
		target.playTurn(new Position(2,2)); // 0

		// when
		String result = target.playTurn(new Position(1,2));

		assertEquals("Tie", result);
	}

	@Test
	void stop_when_player_one_wins_the_game_with_a_row() throws Exception {
		//Given
		target.playTurn(new Position(0,0)); // X
		target.playTurn(new Position(1,1)); // 0
		target.playTurn(new Position(1,0)); // X
		target.playTurn(new Position(2,1)); // 0

		//When
		String result = target.playTurn(new Position(2,0)); // X

		//Then
		assertEquals(result, "Player x wins");
	}

	@Test
	void stop_when_player_one_wins_the_game_with_a_column() throws Exception {
		//Given
		target.playTurn(new Position(0,0)); // X
		target.playTurn(new Position(1,1)); // 0
		target.playTurn(new Position(0,1)); // X
		target.playTurn(new Position(2,1)); // 0

		//When
		String result = target.playTurn(new Position(0,2)); // X

		//Then
		assertEquals(result, "Player x wins");
	}
}