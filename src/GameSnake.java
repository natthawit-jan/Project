/**
 * Java. Classic Game Snake
 *
 * @author Sergey Iryupin
 * @version 0.3.4 dated October 03, 2016
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

class GameSnake extends JFrame {

    static final String TITLE_OF_PROGRAM = "Classic Game Snake";
    static final String GAME_OVER_MSG = "GAME OVER";
    static final int POINT_RADIUS = 25; // size of one point
    static final int FIELD_WIDTH = 30; // in point
    static final int FIELD_HEIGHT = 20;
    static final int FIELD_DX = 6; // determined experimentally
    static final int FIELD_DY = 28;
    static final int START_LOCATION = 200;
    static final int START_SNAKE_SIZE = 6;
    static final int START_SNAKE_X = 10;
    static final int START_SNAKE_Y = 10;
    static final int SHOW_DELAY = 150; // delay for animation
    static final int LEFT = 37; // key codes
    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;
    static final int START_DIRECTION = RIGHT;
    static final Color DEFAULT_COLOR = Color.gray;
    static final Color FOOD_COLOR = Color.green;
    static final Color POISON_COLOR = Color.red;

    Random random;
    Canvas canvas;
    Snake snake;
    Food food;
    Poison poison;
    boolean gameOver = false;
    private int score = START_SNAKE_SIZE;

    public static void main(String[] args) { new GameSnake().go(); }

    GameSnake() {

        random = new Random();
        canvas = new Canvas();
        snake = new Snake(this, START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
        food = new Food(this);
        poison = new Poison(this);


//        setBackground(Color.red);

        setTitle(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
        setResizable(false);
        canvas.setBackground(Color.yellow);
        add(BorderLayout.CENTER, canvas);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
//                System.out.println(e.getKeyCode());
            }
        });
        setVisible(true);
    }


    void go() { // main loop of game
        while (!gameOver) {
            snake.move();

            if (food.isEaten()) {
                setTitle(TITLE_OF_PROGRAM + " : " + score);
                score++;
                food.next();
                poison.add();
            }
            canvas.repaint();
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }


    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            snake.paint(g);
            food.paint(g);
            poison.paint(g);
            if (gameOver) {
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 60));
                FontMetrics fm = g.getFontMetrics();
                g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG))/2, (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY)/2);
            }
        }
    }
}