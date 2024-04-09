package main;

/**
 * A class to represent a potential turn (piece selection and movement).
 */

public class Turn {
    private int rowO, colO, rowD, colD;
    private String styleName;
    private char player;


    /**
     * Constructs a move (piece placement) that knows its row, col
     * movement from origin to destination on the grid
     *
     * @param row_o	integer representing the origin row of the piece to move
     * @param col_o	integer representing the origin column of the piece to move
     * @param row_d	integer representing the destination row of the piece to move
     * @param col_d	integer representing the destination column of the piece to move
     * @param styleName string representing the style being used to move
     * @param player the character representing the player making this Turn
     */
    public Turn(int row_o, int col_o, int row_d, int col_d, String styleName, char player) {
        this.rowO = row_o;
        this.colO = col_o;
        this.rowD = row_d;
        this.colD = col_d;
        this.styleName = styleName;
        this.player = player;
    }

    /**
     * Returns the origin row of this potential turn.
     *
     * @return int of origin row
     */
    public int getRowO() {
        return rowO;
    }

    /**
     * Returns the origin col of this potential turn.
     *
     * @return int of origin column
     */
    public int getColO() {
        return colO;
    }

    /**
     * Returns the destination row of this potential turn.
     *
     * @return int of destination row
     */
    public int getRowD() {
        return rowD;
    }

    /**
     * Returns the destination col of this potential turn.
     *
     * @return int of destination col
     */
    public int getColD() {
        return colD;
    }

    /**
     * Returns the using style name as string
     *
     * @return style name as a string
     */
    public String getStyle() {
        return styleName;
    }

    /**
     * Returns string representation of this move in the form "X: (0,0,dragon) -> (1,2)".
     *
     * @return String type in the form of "X: (0,0,dragon) -> (1,2)" stating this move's
     * alterations
     */
    @Override
    public String toString() {
        return player +": (" + rowO + "," + colO + "," + styleName +
                ") -> (" + rowD + "," + colD + ")";
    }

    /**
     * Main function which creates three random turns and print them out.
     */
    public static void main(String[] args){
        // Create Turns
        Turn t1 = new Turn(0, 0, 1, 2, "dragon", 'X');
        Turn t2 = new Turn(3, 2, 2, 2, "crab", 'O');
        Turn t3 = new Turn(2, 2, 3, 1, "rooster", 'X');

        // Print Turns
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}

