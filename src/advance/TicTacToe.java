package advance;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' '; // The board is empty
            }
        }

        // Initialize player
        char player = 'X';
        boolean isGameOver = false; // the hasn't start yet

        Scanner scanner = new Scanner(System.in);
        while (!isGameOver) {
            printBoard(board); // Print the board for the game
            System.out.println("Player " + player + " enter: ");
            int row = scanner.nextInt(); // take the row
            int col = scanner.nextInt(); // take the column

            if (board[row][col] == ' ') {
                board[row][col] = player; // Place the element or play
                isGameOver = hasWon(board, player);

                if (isGameOver)
                    System.out.println("Player " + player + " has won");
                else {
                    // checks for the player that plays, switch between players
                    // if the player that plays is X, place the O character on the board
                    // if the player that plays is not X, place the X character on the board
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                if (board[row][col] != ' ' && !hasWon(board, player)) {
                    System.out.println("GAME OVER, NO WINNER!");
                    System.exit(0);
                } else {
                    System.out.println("Invalid move. try again");
                }
            }
        }
    }


    // Check for the winner
    private static boolean hasWon(char[][] board, char player) {

        // Check for winner in rowise direction
        // Rowise
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Columnwise
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // Diagonalwise
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }

    // Prints the board for the tictactoe game
    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
