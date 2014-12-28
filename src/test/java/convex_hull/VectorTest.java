package convex_hull;

import org.junit.Before;
import org.junit.Test;

import static convex_hull.Point.point;
import static convex_hull.Vector.*;
import static java.lang.Math.PI;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Delta.delta;

public class VectorTest {

    private Point a;
    private Point b;
    private Point p;
    private Vector vA;
    private Vector vB;
    private Vector vZ;

    @Before
    public void setUp() throws Exception {
        a = point(0, 1);
        b = point(1, 0);
        p = point(0, 0);
        vA = vector(p, a);
        vB = vector(p, b);
        vZ = vector(p, p);
    }

    @Test
    public void height_works() {
        assertThat(height(vA)).isEqualTo(1);
        assertThat(height(vB)).isEqualTo(0);
        assertThat(height(vZ)).isEqualTo(0);
    }

    @Test
    public void width_works() {
        assertThat(width(vA)).isEqualTo(0);
        assertThat(width(vB)).isEqualTo(1);
        assertThat(width(vZ)).isEqualTo(0);
    }

    @Test
    public void dot_works() {
        assertThat(dot(vA, vB)).isEqualTo(0);
    }

    @Test
    public void magnitude_works() {
        assertThat(magnitude(vA)).isEqualTo(1.0);
        assertThat(magnitude(vB)).isEqualTo(1.0);
        assertThat(magnitude(vZ)).isEqualTo(0.0);
    }

    @Test
    public void angle_returnsAngleBetweenTwoVectors() {
        assertThat(angle(vA, vB)).isEqualTo(2 * PI * 1.0 / 4.0, delta(0.001));
    }
}