package convex_hull;

import org.junit.Before;
import org.junit.Test;

import static convex_hull.Point.point;
import static convex_hull.Vector.*;
import static java.lang.Math.PI;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Delta.delta;

public class VectorTest {

    private Point up;
    private Point right;
    private Point origin;
    private Point upRight;
    private Vector vUp;
    private Vector vRight;
    private Vector vOrigin;
    private Vector vUpRight;

    @Before
    public void setUp() throws Exception {
        up = point(1, 0);
        right = point(0, 1);
        origin = point(0, 0);
        upRight = point(1, 1);
        vUp = vector(origin, up);
        vRight = vector(origin, right);
        vOrigin = vector(origin, origin);
        vUpRight = vector(origin, upRight);
    }

    @Test
    public void deltaY_works() {
        assertThat(deltaY(vUp)).isEqualTo(1);
        assertThat(deltaY(vRight)).isEqualTo(0);
        assertThat(deltaY(vOrigin)).isEqualTo(0);
    }

    @Test
    public void deltaX_works() {
        assertThat(deltaX(vUp)).isEqualTo(0);
        assertThat(deltaX(vRight)).isEqualTo(1);
        assertThat(deltaX(vOrigin)).isEqualTo(0);
    }

    @Test
    public void dot_works() {
        assertThat(dot(vUp, vRight)).isEqualTo(0);
    }

    @Test
    public void magnitude_works() {
        assertThat(magnitude(vUp)).isEqualTo(1.0);
        assertThat(magnitude(vRight)).isEqualTo(1.0);
        assertThat(magnitude(vOrigin)).isEqualTo(0.0);
    }

    @Test
    public void angle_returnsAngleBetweenTwoVectors() {
        assertThat(angle(vUp, vRight)).isEqualTo(2 * PI * 1.0 / 4.0, delta(0.001));
    }

    @Test
    public void isRightOf_returnsTrueIfPointIsRightOfVector() {
        assertThat(isRightOf(up, vRight)).isTrue();
        assertThat(isRightOf(right, vUp)).isFalse();
    }

    @Test
    public void slope_works() {
        assertThat(slope(vUpRight)).isEqualTo(1.0);
        assertThat(slope(vUp)).isEqualTo(Double.MAX_VALUE);
        assertThat(slope(vRight)).isEqualTo(0.0);
    }
}