package system_design.api;

import java.util.List;

/*
 * A card dealer, the maestro of the table.
 */
public interface Dealer {
    /*
     * Deal a single card to a player, and collect a single card from
     * a player, respectively. In both cases, card instances should be
     * preserved: a card should be explicitly removed from one location
     * (a deck or a hand) and added to the other.
     */
     void dealCard(Player player);

     void collectCards(Player player);

    /*
     * Get the hand of the dealer.
     */
     Hand getHand();

    /*
     * Shuffle the cards.
     */
     void shuffle();
}