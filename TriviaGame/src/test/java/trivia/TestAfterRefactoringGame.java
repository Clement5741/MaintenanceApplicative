package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestAfterRefactoringGame {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testAddPlayer() {
        assertTrue(game.add("Alice"));
    }

    @Test
    void testPlayerRoll() {
        game.add("Bob");
        game.roll(4);
        assertEquals(5, game.players.get(0).getPosition());
    }

    @Test
    void testHandleCorrectAnswer() {
        game.add("Charlie");
        assertTrue(game.handleCorrectAnswer());
    }

    @Test
    void testHandleWrongAnswer() {
        game.add("Dana");
        assertTrue(game.handleWrongAnswer());
    }

    @Test
    void testHandleCorrectAnswerWhenPlayerIsInPenaltyBox() {
        game.add("Eve");
        game.roll(4);
        game.handleWrongAnswer();
        game.roll(4);
        assertTrue(game.handleCorrectAnswer());
    }

    @Test
    void testRollOutOfPenaltyBox() {
        game.add("Frank");
        game.roll(4);
        game.handleWrongAnswer();
        game.roll(5);
        assertFalse(game.players.get(0).isInPenaltyBox());
    }
}




