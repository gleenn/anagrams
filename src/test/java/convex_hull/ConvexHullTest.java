package convex_hull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static convex_hull.ConvexHull.getHullEdges;
import static convex_hull.ConvexHull.getHullEdgesFast;
import static convex_hull.Point.point;
import static convex_hull.Vector.vector;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class ConvexHullTest {

    private Point up;
    private Point left;
    private Point right;
    private Point down;
    private Point center;

    @Before
    public void setUp() throws Exception {
        right = point(0, 1);
        up = point(1, 0);
        left = point(0, -1);
        down = point(-1, 0);
        center = point(0, 0);
    }

    @Test
    public void getHullEdges_works() {
        // note that this is implementation specific
        // and the edges are actually undirected so there
        // there are more possibilities that just the
        // specific vectors listed below
        List<Vector> hullEdges = getHullEdges(asList(right, up, left, down, center));
        assertThat(hullEdges).contains(vector(right, down));
        assertThat(hullEdges).contains(vector(left, down));
        assertThat(hullEdges).contains(vector(up, left));
        assertThat(hullEdges).contains(vector(right, up));
    }

    @Test @Ignore
    public void getHullEdgesFast_works() {
        List<Vector> hullEdges = getHullEdgesFast(asList(right, up, left, down, center));
        assertThat(hullEdges).contains(vector(right, down));
        assertThat(hullEdges).contains(vector(left, down));
        assertThat(hullEdges).contains(vector(up, left));
        assertThat(hullEdges).contains(vector(right, up));
    }
}