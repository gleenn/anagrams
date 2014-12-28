package convex_hull;

public class Point {
    public final int x;
    public final int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public static Point point(int y, int x) {
        return new Point(y, x);
    }

}
