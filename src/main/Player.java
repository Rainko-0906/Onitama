package main;

/**
 * A class to represent a player in onitama game.
 * A player should be represented as a char just like 'X' or 'O'
 */
public class Player {

    protected final char player;

    /**
     * Constructs an player.
     *
     * @param player Current player represents as 'X' or 'O'.
     */
    public Player(char player) {
        this.player = player;
    }

    /**
     * A method that need to be inherited. In the child class this method should
     * return a turn instance that contains the points of origin and destination,
     * also style and current player
     * @return Turn type that has all the info that child class got.
     */
    public Turn getTurn() {
        return null;
    }

    /**
     * Return the player as a char
     *
     * @return player 'X' or 'O'
     */
    public char getPlayer() {
        return player;
    }
}

