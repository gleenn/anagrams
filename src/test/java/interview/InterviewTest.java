package interview;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class InterviewTest {
    @Test
    public void testAdd() {
        assertThat(Interview.add(1, 2)).isEqualTo(3);
    }
}
