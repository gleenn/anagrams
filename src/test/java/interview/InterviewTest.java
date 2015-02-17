package interview;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class InterviewTest {
    @Test
    public void testMatches() {
        assertThat(Interview.matches("", "a")).isTrue();
        assertThat(Interview.matches("a", "a")).isTrue();
        assertThat(Interview.matches("ab?", "a")).isTrue();
        assertThat(Interview.matches("ab?a?", "aba")).isTrue();
        assertThat(Interview.matches("ab?a?", "aa")).isTrue();
        assertThat(Interview.matches("ab?a?", "a")).isTrue();
        assertThat(Interview.matches("ab?a?a", "abaa")).isTrue();
        assertThat(Interview.matches("ab?a?a", "aa")).isTrue();
        assertThat(Interview.matches("ab?a?a", "aaa")).isTrue();

        assertThat(Interview.matches("aa", "a")).isFalse();
    }

    @Test
    public void foo() {
        String[] parts = "aa".split("a");
        assertThat(parts.length == 0);

        String[] parts2 = "aa".split("z");
        assertThat(parts2.length).isEqualTo(1);
    }
}
