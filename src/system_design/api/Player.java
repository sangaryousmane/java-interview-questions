package system_design.api;

/*
 * A card player.
 */
public interface Player extends Comparable<Player> {
    /*
     * Receive a card
     */
     void receive(Card card);

    /*
     * Return the current hand to the caller
     */
     Hand getHand();

    /*
     * Place a wager
     */
     double wager();

    /*
     * Give a player money (upon winning a round)
     */
     void payOut(double money);

    /*
     * Return the amount of money currently available to the player
     */
     double getMoney();

    /*
     * Return the name of the player
     */
     String getName();

    /*
     * Whether the player would like to request a card: true indicates
     * that they would (equivalent to a 'hit' in Black Jack); false
     * indicates they would not.
     */
     boolean requestCard();
}