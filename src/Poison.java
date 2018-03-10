import java.awt.*;
import java.util.ArrayList;

class Poison {

    private ArrayList<Point> poison = new ArrayList<Point>();
    private GameSnake game;

    Poison(GameSnake game) {
        this.game = game;
    }

    boolean isPoison(int x, int y) {
        for (Point p : poison){
            if (p.getX() == x && p.getY() == y){
                return true;
            }

        }

        return false;
    }

    void add() {
        int x, y;
        do {
            x = game.random.nextInt(GameSnake.FIELD_WIDTH);
            y = game.random.nextInt(GameSnake.FIELD_HEIGHT);
        } while (isPoison(x, y) || game.snake.isInsideSnake(x, y) || game.food.isFood(x, y));
        poison.add(new Point(x, y));
    }

    void paint(Graphics g) {
        int r = GameSnake.POINT_RADIUS;
        g.setColor(GameSnake.POISON_COLOR);
        for (Point point : poison) {
            g.fill3DRect(point.getX()*r + 1, point.getY()*r + 1, r - 2, r - 2, true);
        }
    }
}