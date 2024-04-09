package main;

/**
 * A class to represent a potential piece movement.
 */
public class Move {

    private int row, col;

    /**
     * Constructs a move (piece placement) that knows its row, col
     * movement, based on modification from its current position
     *
     * @param row integer representing how a piece moves along a row
     * @param col integer representing how a piece moves along a column
     */
    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row of this move.
     *
     * @return int Row number of this move.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this move.
     *
     * @return int Column number of this move.
     */
    public int getCol() {
        return col;
    }


    /**
     * Returns string representation of this move in the form "(row, col)".
     *
     * @return a string in the form of "(row, col)" stating this move's alterations
     */
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }

}


