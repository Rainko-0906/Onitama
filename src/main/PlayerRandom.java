package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * An random player class that generate a bot in onitama game, this class will pick up a
 * random token of current bot, then pick up a random valid style to generate a list of
 * valid moves, then pick a random move from the list and implement the movement.
 */
public class PlayerRandom extends Player {

    private Onitama onitama;

    /**
     * Constructs an player of onitama game.
     * @param player Represent which player it is, 'X' for player1, 'O' for player2
     */
    public PlayerRandom(char player) {
        super(player);
    }

    /**
     * Choose a random style and a random origin to generate a array list of
     * valid moves, then pick one move randomly from the list and save the
     * info in to a turn instance.
     *
     * @param style the movement style to be exchanged.
     * @return Turn with the parameter origin row, origin col, desination rol,
     * destination col, style name as string, current player.
     */
    @Override
    public Turn getTurn() {

        Style style = getRandomStyle();
        Move origin = getRandomOrigin();
        ArrayList<Move> valid_move = getRandomMove(origin, style);

        while (valid_move.size() == 0) {
            origin = getRandomOrigin();
            style = getRandomStyle();
            valid_move = getRandomMove(origin, style);
        }
        Random random_destination = new Random();
        int destination_index = random_destination.nextInt(valid_move.size());
        Move destination = valid_move.get(destination_index);

        return new Turn(origin.getRow(), origin.getCol(),
                destination.getRow(), destination.getCol(),
                style.getName(), this.player);
    }

    /**
     * Update the board info for this bot.
     *
     * @param onitama the board instances that currently running.
     */
    public void setOnitama(Onitama onitama) {
        this.onitama = onitama;
    }

    /**
     * Return a random token coordinate based on which player it is.
     *
     * @return Move type, A coordinate of the origin token according to current player.
     */
    private Move getRandomOrigin() {

        ArrayList<Move> origins = new ArrayList<>();
        char[][] board = onitama.getBoard();

        if (player == OnitamaBoard.G1) {
            for (int i = 0; i < onitama.getBoard().length; i++) {
                for (int j = 0; j < onitama.getBoard().length; j++) {
                    if (board[i][j] == OnitamaBoard.G1 || board[i][j] == OnitamaBoard.M1) {
                        origins.add(new Move(i, j));
                    } } }
        } else if (player == OnitamaBoard.G2) {
            for (int k = 0; k < onitama.getBoard().length; k++) {
                for (int l = 0; l < onitama.getBoard().length; l++) {
                    if (board[k][l] == OnitamaBoard.G2 || board[k][l] == OnitamaBoard.M2) {
                        origins.add(new Move(k, l));
                    } } }
        }
        Random random_origin = new Random();
        int origin_index = random_origin.nextInt(origins.size());

        return origins.get(origin_index);
    }

    /**
     * Return a random style that current player owned.
     *
     * @return Style type, A random valid style for current player.
     */
    private Style getRandomStyle() {

        ArrayList<Style> valid_styles = new ArrayList<>();

        if (player == OnitamaBoard.G1) {
            for (Style style : onitama.getStyles()) {
                if (style.getOwner() == OnitamaBoard.G1) {
                    valid_styles.add(style);
                } }
        } else if (player == OnitamaBoard.G2) {
            for (Style style : onitama.getStyles()) {
                if (style.getOwner() == OnitamaBoard.G2) {
                    valid_styles.add(style);
                } }
        }
        Random random_style = new Random();
        int style_index = random_style.nextInt(valid_styles.size());

        return valid_styles.get(style_index);
    }

    /**
     * Return a random destination coordinate based on given origin and style.
     *
     * @param origin A random token coordinate based on current player.
     * @param Style A random valid style for current player.
     * @return ArrayList<Move> All the valid moves, can be empty when no valid moves.
     */
    private ArrayList<Move> getRandomMove(Move origin, Style curr_style) {

        ArrayList<Move> valid_move = new ArrayList<>();

        if (player == OnitamaBoard.G1) {
            for (Move move : curr_style.getMoves()) {

                Move destination = new Move(origin.getRow() - move.getRow(),
                        origin.getCol() - move.getCol());

                if (onitama.isLegalMove(origin.getRow(), origin.getCol(),
                        destination.getRow(), destination.getCol())) {

                    valid_move.add(new Move(destination.getRow(), destination.getCol()));
                } }
        } else if (player == OnitamaBoard.G2) {
            for (Move move : curr_style.getMoves()) {

                Move destination = new Move(origin.getRow() + move.getRow(),
                        origin.getCol() + move.getCol());

                if (onitama.isLegalMove(origin.getRow(), origin.getCol(),
                        destination.getRow(), destination.getCol())) {

                    valid_move.add(new Move(destination.getRow(), destination.getCol()));
                } }
        }
        return valid_move;
    }


}