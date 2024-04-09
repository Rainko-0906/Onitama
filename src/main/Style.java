package main;

/**
 * A class to represent a fighting style (i.e. movement pattern) that can be
 * used to move a piece. Each player has two styles, and there is a fifth style
 * that cannot be used; once a player uses a main.Style to make a move, they exchange
 * that main.Style with the fifth main.Style.
 */

public class Style {

    private char owner = OnitamaBoard.EMPTY; // G1 for player 1, G2 for player 2, EMPTY for fifth style
    private Move[] moves;
    private int moveCount; // number of moves this style has
    private String name;

    /**
     * Constructs a new main.Style. Populates the list of moves using tuples of (row,col)
     * pairs
     *
     * @param pairs array of consecutive movement tuples in the form (row,col)
     * @param name  name of the fighting style
     */

    public Style(int[][] pairs, String name) {
        this.name = name;
        this.moveCount = pairs.length;
        this.moves = new Move[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            Move move = new Move(pairs[i][0], pairs[i][1]);
            this.moves[i] = move;
        }
    }

    /**
     * Sets the owner of the style based on the following: G1 for Player 1, G2 for
     * Player 2, EMPTY for fifth (unavailable) style When a style is passed to or
     * from Player 1, the moves in this style change orientation.
     *
     * @param owner new owner of the style
     */
    public void setOwner(char owner) {
        this.owner = owner;
    }

    /**
     * Returns the owner of this style.
     *
     * @return owner owner of this style
     */
    public char getOwner() {
        return this.owner;
    }

    /**
     * Returns the movements of this style.
     *
     * @return moves movements of this style
     */
    public Move[] getMoves() {
        return this.moves;
    }

    /**
     * Returns the name of this style.
     *
     * @return name name of this style
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns string representation of this move using a 5x5 grid. The origin of
     * the piece is marked by a @ symbol in the center of the grid, with the
     * potential main.Move options indicated by the + symbol.
     *
     * @return a string in the form of a 5x5 grid that shows the possible movements
     */
    public String toString() {

        char[][] grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }
        // point the piece in the direction it should be facing
        if (this.owner == OnitamaBoard.G1) {
            grid[2][2] = 'V';
        } else {
            grid[2][2] = '^';
        }

        for (int i = 0; i < this.moveCount; i++) {
            if (this.owner == OnitamaBoard.G1) {
                // on the opposite side; flip the grid
                grid[2 - this.moves[i].getRow()][2 - this.moves[i].getCol()] = '+';
            } else {
                grid[2 + this.moves[i].getRow()][2 + this.moves[i].getCol()] = '+';
            }
        }

        String strGrid = this.name + ":\n";
        for (int i = 0; i < 5; i++) {
            strGrid += String.valueOf(grid[i]) + "\n";
        }
        return strGrid;
    }
}