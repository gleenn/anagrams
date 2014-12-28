package interview;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.fest.assertions.Assertions.assertThat;

public class Java8Test {
    @Test
    public void testYo() {
        assertThat(asList(1, 2, 3, 4).stream().reduce(Math::max).get()).isEqualTo(4);
        assertThat(asList(1, 2, 3, 4).stream().map((i) -> i * i).collect(toList())).isEqualTo(asList(1, 4, 9, 16));
    }
}