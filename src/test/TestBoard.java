package test;

/**
 * An enum object containing different board states for testing purposes. 
 */
public enum TestBoard {
    BOARD_X1(new char[][]
                    {{' ', ' ', ' ', ' ', 'X'},
                    {' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', 'x', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' '},
                    {'O', ' ', ' ', ' ', ' '}}),
    BOARD_O1(new char[][]
                    {{' ', ' ', ' ', ' ', 'X'},
                    {' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', 'o', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' '},
                    {'O', ' ', ' ', ' ', ' '}});

    private final char[][] board;
    TestBoard(char[][] board){
        this.board = board;
    }

    char[][] getBoard(){
        return this.board;
    }
}
