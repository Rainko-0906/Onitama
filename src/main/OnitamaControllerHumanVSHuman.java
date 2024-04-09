package main;

/**
 * A class to represent a controller for two human player to play, this class will
 * generate two players for human to control, and the controller keep asking each
 * player the style and move they want, also print out each style chosen and the move
 * they made, if one of the player win, print the result board, announce the winner,
 * and terminate the game.
 */
public class OnitamaControllerHumanVSHuman {

    protected Onitama onitama;
    PlayerHuman player1, player2;

    /**
     * Constructs an human vs human game.
     */
    public OnitamaControllerHumanVSHuman() {
        this.player1 = new PlayerHuman(OnitamaBoard.G1);
        this.player2 = new PlayerHuman(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
    }

    /**
     * Running the game.
     * If there is no winner, the game should keep going.
     * Get the each player's turn and their movement,
     * do the move, and report each round.
     */
    public void play() {
        while (onitama.getWinner() == OnitamaBoard.EMPTY) {
            this.report();

            Turn turn = null;
            Player whosTurn = onitama.getWhoseTurn();
            turn = whosTurn.getTurn();

            this.reportTurn(whosTurn.getPlayer(), turn);
            onitama.move(turn.getRowO(), turn.getColO(), turn.getRowD(),
                    turn.getColD(), turn.getStyle());
        }
        this.reportFinal();
    }

    /**
     * Report each move that player made.
     */
    private void reportTurn(char whosTurn, Turn turn) {
        System.out.println(whosTurn + " makes move " + turn + "\n");
    }

    /**
     * Print out the board and 2 separate valid styles for each player,
     * and one fifth style, then report which player is next turn.
     */
    private void report() {

        String s = onitama.getBoardString() + onitama.getStylesString(OnitamaBoard.G1) +
                onitama.getStylesString(OnitamaBoard.G2) +
                onitama.getStylesString(OnitamaBoard.EMPTY)
                + "  " + onitama.getWhoseTurn().getPlayer() + " moves next";
        System.out.println(s);
    }

    /**
     * Print out the result board and announce the winner.
     */
    private void reportFinal() {

        String s = onitama.getBoardString() + "  "
                + onitama.getWinner() + " won\n";
        System.out.println(s);
    }

    /**
     * Main function which creates and runs a human vs human onitama game.
     */
    public static void main(String[] args) {

        OnitamaControllerHumanVSHuman oc = new OnitamaControllerHumanVSHuman();
        oc.play();
    }

}