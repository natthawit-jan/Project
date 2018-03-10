import java.awt.*;
import java.util.*;
import java.util.List;

class Point {
    protected int x, y;

    public Point(int x, int y) {
        setXY(x, y);
    }

    int getX() { return x; }
    int getY() { return y; }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void paint(Graphics g) {
        int r = GameSnake.POINT_RADIUS;
        g.setColor(GameSnake.DEFAULT_COLOR);
        g.fill3DRect(getX()*r + 1, getY()*r + 1, r - 2, r - 2, true); // fillOval()
    }


    public static void main(String[] args) {
        Point p1 = new Point(4,3);
        Point p2 = new Point(4,3);

        List<Point> o = new ArrayList<>(Arrays.asList(p1,p2));

        Set<Point> p = new HashSet<>(o);

        System.out.println(p.size());
    }





}
