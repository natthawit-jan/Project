import java.io.FileWriter;

public class WriteText {
    public static void main(String[] args) {
        try{
            FileWriter fe = new FileWriter("ProjectReport.txt");
            fe.write("This is a basic snake game that we all are familiar with (if you ever played it on an old Nokia). It is one of the first games I played and it makes me wonder what it takes to build. After I learn that a simple game can be created simply by knowledge of JAVA language and by the use of GUI, I try to create this game by my own and here is a result.\n" +
                    "\n" +
                    "The game composes of 5 classes \n" +
                    "\n" +
                    "Food.java\n" +
                    "GameSnake.java\n" +
                    "Point.java\n" +
                    "Poison.java\n" +
                    "Snake.java. \n" +
                    "\n" +
                    "Each class represents each important component of the game. For example, Food class basically creates food randomly on frame. It also checks whether the snake already eats the food. It also makes sure that the food will not be created on the snake’s current position. \n" +
                    "\n" +
                    "\n" +
                    "The Point class is just a class that provides everything about the position. Its construction creates the coordinate X, Y  \n" +
                    "\n" +
                    "To make this game more elegant than the normal version, I added the feature called Poison into the game. The red poison will be randomly created everytime the snake eats the food. Therefore, apart from eating food, avoiding crashing itself, the user still has to stay away from the poison as well. \n" +
                    "\n" +
                    "The Snake class builds the snake as its name implies. It starts by initialising 6 points in the point class to the start the game. When it eats the food, it grows bigger by 1 point. If it crashes itself, or accidentally eats a poison, the “game over” will be displayed. It also detect direction from the player such as UP DOWN RIGHT LEFT. \n" +
                    "\n" +
                    "The GameSnake Class gules everything together. It will forever run the snake game until its “isGameOver” stage changes to true. ");
            fe.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
