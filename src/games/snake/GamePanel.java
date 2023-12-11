package games.snake;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 75;

    public GamePanel() {}

    // Starts game
    public void startGame(){

    }

    // paint the component
    public void paintComponent(Graphics graphics){

    }

    // Draw on the screen
    public void draw(Graphics graphics){

    }

    // Move the snake
    public void move(){

    }
    // Eat the apple
    public void checkApple(){

    }

    // Check for collisions
    public void checkCollisions(){

    }
    // Game over
    public void gameOver(Graphics graphics){

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
    }
}
