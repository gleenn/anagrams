package convex_hull;

import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

public class Vector {
    public final Point orig;
    public final Point dest;

    public Vector(Point orig, Point dest) {
        this.orig = orig;
        this.dest = dest;
    }

    public static int height(Vector v) {
        return v.dest.y - v.orig.y;
    }

    public static int width(Vector v) {
        return v.dest.x - v.orig.x;
    }

    public static Vector vector(Point orig, Point dest) {
        return new Vector(orig, dest);
    }

    public static int dot(Vector a, Vector b) {
        return width(a) * width(b) + height(a) * height(b);
    }

    public static double magnitude(Vector v) {
        return sqrt(height(v) * height(v) + width(v) * width(v));
    }

    public static double angle(Vector a, Vector b) {
        return acos(dot(a, b) / (magnitude(a) * magnitude(b)));
    }
}
