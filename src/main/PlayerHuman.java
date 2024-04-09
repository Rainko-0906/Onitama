package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * An human player class that generate a human player in onitama game, this class will
 * ask player the style they would like to choose, the origin row and column, the destination
 * row and column, if the input is valid and the move is legal, movement will be made.
 */
public class PlayerHuman extends Player{

    private static final String INVALID_MOVE_INPUT_MESSAGE = "Invalid number, please enter 0-4";
    private static final String INVALID_STYLE_INPUT_MESSAGE = "Invalid style, please enter one of this player's styles " +
            "(Dragon, Crab, Horse, Mantis, Rooster)";
    private static final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Constructs an player of onitama game.
     * @param player Represent which player it is, 'X' for player1, 'O' for player2
     */
    public PlayerHuman(char player) {
        super(player);
    }

    /**
     * This method will read the input message about the styles and movement that a human
     * player want to choose.
     *
     * @return Turn with the parameter origin row, origin col, destination row,
     * destination col, style name as string, current player.
     */
    @Override
    public Turn getTurn() {
        String style_name = "";
        try {
            System.out.print("Choose your style:");
            style_name = PlayerHuman.stdin.readLine();
        } catch (IOException e) {
            System.out.println(INVALID_STYLE_INPUT_MESSAGE);
        }
        int row_o = getMove("row origin: ");
        int col_o = getMove("col origin: ");
        int row_d = getMove("row destination: ");
        int col_d = getMove("col destination: ");
        return new Turn(row_o, col_o, row_d, col_d, style_name, this.player);
    }

    /**
     * This method will read the input message about the row and col that a human
     * player want to choose, if the input is lower than 0 or higher than 4, no
     * info will be saved and print out the invalid move message.
     *
     * @param message The info that will ask player to choose.
     * @return If the move input is valid, return the input, otherwise return -1.
     */
    private int getMove(String message) {
        int move, lower = 0, upper = 4;
        while (true) {
            try {
                System.out.print(message);
                String line = PlayerHuman.stdin.readLine();
                move = Integer.parseInt(line);
                if (lower <= move && move <= upper) {
                    return move;
                } else {
                    System.out.println(INVALID_MOVE_INPUT_MESSAGE);
                }
            } catch (IOException e) {
                System.out.println(INVALID_MOVE_INPUT_MESSAGE);
                break;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_MOVE_INPUT_MESSAGE);
            }
        }
        return -1;
    }
}
