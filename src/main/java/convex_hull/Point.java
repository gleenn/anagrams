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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if(x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "[" + y + ", " + x + "]";
    }
}
