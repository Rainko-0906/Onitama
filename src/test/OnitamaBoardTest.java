package test;

import main.OnitamaBoard;
import main.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnitamaBoardTest {
    OnitamaBoard ob;
    private final int size = 5;

    /*
     * ==== Test Helpers ====
     * This is a place to add helper functions for your test cases
     */

    /*
     * ==== Test Cases ====
     * This is where you should add your test cases!
     */

    @BeforeEach
    public void setUp() {
        // This runs before each test method, so we have a fresh OnitamaBoard for each
        // test.
        ob = new OnitamaBoard(size);
    }

    @Test
    public void testSetGetToken() {
        // Example of how to do test cases, we set the token, and then get the token and
        // see if the results
        // match our expectations
        ob.setToken(2, 0, 'i');
        // Format for asserts is assertEquals(EXPECTED, ACTUAL)
        assertEquals('i', ob.getToken(2, 0));
    }

    @Test
    public void testGetDimension() {

    }

    @Test
    public void testConstructStyles() {

    }

    @Test
    public void testExchangeStyle() {

    }
}
