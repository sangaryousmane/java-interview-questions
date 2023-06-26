package system_design.impl;

import java.util.HashSet;

import system_design.api.Card;
import system_design.api.Hand;

/*
 * A hand is a collection of cards.
 */
public class BlackJackHand extends Hand {

	/*
     * The set of cards currently in a hand
     */
	public int suit;
	
	public BlackJackHand(){
		this.cards = new HashSet<>();
		this.suit = 0;
	}
	
	public int compareTo(Hand c){
		if (this.valueOf() < c.valueOf()){
			return -1;
		}
		else if (this.valueOf() == c.valueOf()){
			int suitsOfDealer = 0;
			for (Card dealers : c.getCards()){
				suitsOfDealer += dealers.getSuit().getSuit();
			}
			if (suitsOfDealer > this.suit){
				return -1;
			}
			else if (suitsOfDealer == this.suit){
				return 0;
			}
			else{
				return 1;
			}
			
		}
		else{
			return 1;
		}
	}



    /*
     * Determination of valid and winning hands, respectively. Your
     * implementation should answer that question with respect to the
     * rules of Black Jack, but irrespective of what other players at
     * the table have (including the dealer).
     */
    public boolean isValid(){
		return this.valueOf() <= 21;
    }

	// You're a winner when your value is equal to 21
    public boolean isWinner(){
		return this.valueOf() == 21;
    }

    /*
     * The value of the hand, as an integer.
     */
    public int valueOf(){
        int valid = 0;
        for (Card card : cards) {
            valid += card.getValue().getValue();
        }
        return valid;
    }
}