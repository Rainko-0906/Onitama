package main;

/**
 * A class to represent a controller for a bot vs bot game.
 * This class will generate 2 bots that both can not be controlled by human, two bots
 * will move automatically, then print out the style chosen and the move they made, if
 * one of the bot win, print the result board, announce the winner and terminate the game.
 */
public class OnitamaControllerRandomVSRandom {
    protected Onitama onitama;
    PlayerRandom player1, player2;

    /**
     * Constructs an bot vs bot game, both player are bots.
     */
    public OnitamaControllerRandomVSRandom() {
        this.player1 = new PlayerRandom(OnitamaBoard.G1);
        this.player2 = new PlayerRandom(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
        this.player1.setOnitama(onitama);
        this.player2.setOnitama(onitama);
    }

    /**
     * Running the game.
     * If there is no winner, the game should keep going.
     * Get the each player's turn and their movement,
     * then do the move, and report each round.
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
     * Report each move that current bot made.
     */
    private void reportTurn(char whosTurn, Turn turn) {
        System.out.println(whosTurn + " makes move " + turn + "\n");
    }

    /**
     * Print out the board and 2 separate valid styles for each bot,
     * and one fifth style, then report which bot is next turn.
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
     * Main function which creates and runs a bot vs bot onitama game.
     */
    public static void main(String[] args) {

        OnitamaControllerRandomVSRandom oc = new OnitamaControllerRandomVSRandom();
        oc.play();
    }
}