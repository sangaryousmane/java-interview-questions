package system_design.test;

import system_design.impl.BlackJackTable;
import system_design.api.Table;

/*
 * For now there is a single "test": to play a game until all players
 * are out.txt of money (unless you're a Black Jack wizard, that point
 * should come).
 *
 * Use this test as a template for how the program should work;
 * essentially, everything is driven through the table.
 */
public class BlackJackGame {
    public static void main(String[] args) {
	//int numberOfPlayers = Integer.parseInt(args[0]);
	int numberOfPlayers = 5;
	Table table = new BlackJackTable(numberOfPlayers);
	for (int i = 1; !table.isGameOver(); i++) {
	    System.out.println("Round " + i);
	    table.round();
	    System.out.println(table);
	}
    }
}