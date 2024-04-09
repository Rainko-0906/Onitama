package main;

/**
 * A class to represent a controller for a human to play with a bot, this class will
 * generate 1 players for human to control, and the controller will keep asking human
 * player the style and move they want, bot will move automatically, then print out
 * each style chosen and the move they made, if one of the player win, print the result
 * board, announce the winner, and terminate the game.
 */
public class OnitamaControllerHumanVSRandom {
    protected Onitama onitama;
    PlayerRandom player1;
    PlayerHuman player2;

    /**
     * Constructs an human vs bot game, player1 is a bot, player2 is a human.
     */
    public OnitamaControllerHumanVSRandom() {
        this.player1 = new PlayerRandom(OnitamaBoard.G1);
        this.player2 = new PlayerHuman(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
        this.player1.setOnitama(onitama);
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
     * Main function which creates and runs a human vs bot onitama game.
     */
    public static void main(String[] args) {

        OnitamaControllerHumanVSRandom oc = new OnitamaControllerHumanVSRandom();
        oc.play();
    }
}