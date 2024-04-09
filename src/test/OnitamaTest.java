package test;

import main.Onitama;
import main.OnitamaBoard;
import main.Player;
import main.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnitamaTest {
    Onitama o;
    Player p1;
    Player p2;
    private final int size = 5;
    private static final char EMPTY = ' ', M1 = 'x', G1 = 'X', M2 = 'o', G2 = 'O';
    Style[] styles;
    char[][] board;

    /*
     * ==== Test Helpers ==== 
     * This is a place to add helper functions for your test cases
     * 
     */

    /**
     * Asserts that the two boards are deeply equal
     * 
     * @param expected the expected board result
     * @param actual   the actual board result
     */
    private void assertBoardEquals(char[][] expected, char[][] actual) {
        // Assert each inner array is equal
        for (int i = 0; i < size; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    /*
     * ==== Test Cases ==== 
     * This is where you should add your test cases!
     */

    @BeforeEach
    public void setUp() {
        // Sets up this Onitama test.
        p1 = new Player(OnitamaBoard.G1);
        p2 = new Player(OnitamaBoard.G2);
        o = new Onitama(p1, p2, 5);
        styles = o.getStyles();
    }

    @Test
    public void testMovementDragon() {

    }

    @Test
    public void testMovementCrab() {

    }

    @Test
    public void testMovementHorse() {

    }

    @Test
    public void testMovementMantis() {

    }

    @Test
    public void testMovementRooster() {

    }

    @Test
    public void testOtherPlayer() {

    }

    @Test
    public void testIsLegalMove() {

    }

    @Test
    public void testGetWinner() {

    }

    @Test
    public void testAll() {
        // Run a simulation of a standard game of Onitama
        board = o.getBoard(); // starting state
    }

    @Test
    public void testDifferentDimension() {
        // Run a simulation of a game of Onitama with dimension 7.
        o = new Onitama(7);
        assertEquals(7, Onitama.DIMENSION);
        board = o.getBoard();
    }
}
