package interview;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class GrepTest {
    @Test
    public void grep() {
        assertThat(Grep.grep("b", new ArrayList<>(asList("a", "a", "a", "a", "b", "a", "a", "a", "a")))).
                isEqualTo(asList("a", "a", "a", "b", "a", "a", "a"));
        assertThat(Grep.grep("b", new ArrayList<>(asList("a")))).isEqualTo(asList());
        assertThat(Grep.grep("b", new ArrayList<>(asList("b")))).isEqualTo(asList("b"));
        assertThat(Grep.grep("b", new ArrayList<>(asList("a", "b", "a")))).isEqualTo(asList("a", "b", "a"));
    }
}