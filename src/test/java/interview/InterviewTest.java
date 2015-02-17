package interview;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class InterviewTest {
    @Test
    public void testMatches() {
        assertThat(Interview.matches("", "a")).isFalse();
        assertThat(Interview.matches("a", "a")).isTrue();
        assertThat(Interview.matches("aa", "a")).isFalse();
        assertThat(Interview.matches("ab?", "a")).isTrue();
        assertThat(Interview.matches("ab??", "a")).isTrue();
        assertThat(Interview.matches("ab???", "a")).isTrue();
        assertThat(Interview.matches("ab??", "ab")).isTrue();
        assertThat(Interview.matches("ab???", "ab")).isTrue();
        assertThat(Interview.matches("ab?a?", "aba")).isTrue();
        assertThat(Interview.matches("ab?a?", "aa")).isTrue();
        assertThat(Interview.matches("ab?a?", "a")).isTrue();
        assertThat(Interview.matches("ab?a?a", "abaa")).isTrue();
        assertThat(Interview.matches("ab?a?a", "aa")).isTrue();
        assertThat(Interview.matches("ab?a?a", "aaa")).isTrue();
        assertThat(Interview.matches("aa", "a")).isFalse();
    }
}
