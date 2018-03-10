import java.awt.*;

class Food  {

    protected int x, y;
    GameSnake game;

    public Food(GameSnake game) {
        this.game = game;
        this.x = -1;
        this.y = -1;
    }

    int getX() { return x; }
    int getY() { return y; }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void eat() { this.setXY(-1, -1); }

    boolean isEaten(){ return this.getX() == -1; }

    boolean isFood(int x, int y) { return (this.x == x) && (this.y == y); }

    void next() {
        int x, y;
        do {

            x = game.random.nextInt(GameSnake.FIELD_WIDTH);
            y = game.random.nextInt(GameSnake.FIELD_HEIGHT);
            System.out.println(x + " " + y);
        } while (game.snake.isInsideSnake(x, y) || game.poison.isPoison(x, y));
        this.setXY(x, y);
    }

    void paint(Graphics g) {
        int r = GameSnake.POINT_RADIUS;
        g.setColor(GameSnake.FOOD_COLOR);
        g.fill3DRect(getX()*r + 1, getY()*r + 1, r - 2, r - 2, true);
    }
}
