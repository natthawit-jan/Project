import java.awt.*;
import java.util.*;

class Snake {
    private ArrayList<Point> snake = new ArrayList<>();
    private int direction;


    private GameSnake game;




    public Snake(GameSnake game, int x, int y, int length, int direction) {


        // create a list of points and set the snake's direction

        // IMPLEMENT
        this.game = game;

        for (int i = 0; i < length ; i++){
            snake.add(new Point(x+i,y));

        }

        this.direction = direction;



    }


    boolean isInsideSnake(int x, int y) {

        // parameter  head of snakes
        for (Point p : snake){
            if (p.getX() == x && p.getY() == y){
                return true;
            }

        }









            return false;
        }






    boolean isFood(Food food) {
        Point snakePos = snake.get(snake.size()-1);

        int x = food.getX();
        int y = food.getY();

        if (snakePos.getX() == x && snakePos.getY() == y){

            return true;
        }





        // check whether the snake is getting food
        // IMPLEMENT

        return false;
    }

    void move() {
        Food food =game.food;
        Poison poison = game.poison;




        // add a new point in the right direction
        //  also ything is okay, add a new point to the head
        //        // if the snake eats food,
        //        //   1. food must be gone and respawn at a new random location
        //        //   2. update score in the title
        //        //   3. the snake is longer
        //        // IMPLEMENT
        //        // everytime X goes ,  the last point deletedcheck for game over condition: crash into itself, eat poison
        // if ever
        int x = snake.get(snake.size()-1).getX();
        int y = snake.get(snake.size()-1).getY();

        // against the wall for x axis
        if (x > 29 && x != 30) x = -1;
        else if ( x < 0) x = 30;
        // against the wall for y axis

        if (y > 19 && y != 20) y = -1;
        else if (y < 0) y = 20;

//        printCurrentPoint(snake.get(snake.size()-1));

        //set direction
        if (direction == GameSnake.RIGHT){
            if (isInsideSnake(x+1, y)){
                game.gameOver = true;

            }
            snake.add(new Point(x+1,y)); }
        else if (direction == GameSnake.LEFT){
            if (isInsideSnake(x-1, y)){
                game.gameOver = true;

            }

            snake.add(new Point(x-1,y));
        }
        else if (direction == GameSnake.UP){

            if (isInsideSnake(x, y-1)){
                game.gameOver = true;

            }

            snake.add(new Point(x, y-1));
        }
        else {

            if (isInsideSnake(x, y+1)){
                game.gameOver = true;

            }
            snake.add(new Point(x,y+1));
        }


        x= snake.get(snake.size()-1).getX();
        y = snake.get(snake.size()-1).getY();

        if (poison.isPoison(x, y)){
            game.gameOver = true;

        }







        if (isFood(food)){
            food.eat();
            //Where is a food

            snake.add(snake.get(snake.size()-1));
            }




        snake.remove(0);









    }

    void printCurrentPoint(Point currentPoint ){
        System.out.println("currentPoint X = " + currentPoint.getX() + "currentPoint Y = " + currentPoint.getY());

    }

    void setDirection(int direction) {
        this.direction = direction;



    }

    void paint(Graphics g) {
        for (Point point : snake) point.paint(g);
    }
}
