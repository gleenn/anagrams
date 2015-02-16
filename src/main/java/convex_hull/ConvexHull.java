package convex_hull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static convex_hull.Vector.isRightOf;
import static convex_hull.Vector.vector;

public class ConvexHull {
    public static List<Vector> getHullEdgesFast(final List<Point> points) {
        final List<Point> sortedPoints = new ArrayList<>(points);
        sortedPoints.sort(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.x - b.x;
            }
        });

        return null;
    }

    public static List<Vector> getHullEdges(final List<Point> points) {
        final List<Vector> result = new ArrayList<>(points.size());
        Vector currentVector = null;
        for(int i = 0; i < points.size() - 2; i++) {
            for(int j = i+1; j < points.size(); j++) {
                int countRightOf = 0;
                for(int k = 0; k < points.size(); k++) {
                    if(k == i || k == j) continue;
                    currentVector = vector(points.get(i), points.get(j));
                    if(isRightOf(points.get(k), currentVector)) {
                        countRightOf++;
                    }
                }
                if(countRightOf == 0 || countRightOf == points.size() - 3) {
                    result.add(currentVector);
                }
            }
        }
        return result;
    }
}
