package convex_hull;

import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

public class Vector implements Comparable<Vector> {
    public final Point orig;
    public final Point dest;

    public Vector(Point orig, Point dest) {
        this.orig = orig;
        this.dest = dest;
    }

    public static int deltaY(Vector v) {
        return v.dest.y - v.orig.y;
    }

    public static int deltaX(Vector v) {
        return v.dest.x - v.orig.x;
    }

    public static Vector vector(Point orig, Point dest) {
        return new Vector(orig, dest);
    }

    public static int dot(Vector a, Vector b) {
        return deltaX(a) * deltaX(b) + deltaY(a) * deltaY(b);
    }

    public static double magnitude(Vector v) {
        return sqrt(deltaY(v) * deltaY(v) + deltaX(v) * deltaX(v));
    }

    public static double angle(Vector a, Vector b) {
        return acos(dot(a, b) / (magnitude(a) * magnitude(b)));
    }

    public static boolean isRightOf(Point p, Vector v) {
        return slope(v) * p.x < p.y;
    }

    public static double slope(Vector v) {
        int dx = deltaX(v);
        return dx == 0 ? Double.MAX_VALUE : ((double) deltaY(v)) / dx;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if(!dest.equals(vector.dest)) return false;
        return orig.equals(vector.orig);

    }

    @Override
    public int hashCode() {
        int result = orig.hashCode();
        result = 31 * result + dest.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + orig + ", " + dest + ")";
    }

    @Override
    public int compareTo(Vector other) {
        return
                other.dest.y - dest.y != 0 ? other.dest.y - dest.y :
                other.dest.x - dest.x != 0 ? other.dest.x - dest.x :
                other.orig.y - orig.y != 0 ? other.orig.y - orig.y :
                other.orig.x - orig.x != 0 ? other.orig.x - orig.x :
                0;
    }
}
