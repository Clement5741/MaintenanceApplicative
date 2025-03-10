package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trivia.Player;

import static org.junit.jupiter.api.Assertions.*;

public class TestAfterRefactoringPlayer {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Eve");
    }

    @Test
    void testMove() {
        player.move(5);
        assertEquals(6, player.getPosition());
    }

    @Test
    void testAddCoin() {
        player.addCoin();
        assertEquals(1, player.getCoins());
    }

    @Test
    void testPenaltyBox() {
        player.goToPenaltyBox();
        assertTrue(player.isInPenaltyBox());
        player.getOutOfPenaltyBox();
        assertFalse(player.isInPenaltyBox());
    }

    @Test
    void testPosition() {
        player.move(12);
        assertEquals(1, player.getPosition());
    }

    @Test
    void getNames() {
        assertEquals("Eve", player.getName());
    }
}

