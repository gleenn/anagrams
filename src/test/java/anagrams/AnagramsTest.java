package anagrams;

import org.junit.Test;

import java.util.HashSet;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;


public class AnagramsTest {

    private Anagrams anagrams;

    @Test
    public void add() {
        anagrams = new Anagrams();
        anagrams.add("foo");
        anagrams.add("ofo");
        anagrams.add("oof");
        anagrams.add("oo");
        anagrams.add("oo");
        anagrams.add("oo");
        anagrams.add("abab");
        anagrams.add("baba");

        assertThat(anagrams.get("oo")).isEqualTo(new HashSet<>(asList("oo")));
        assertThat(anagrams.get("foo")).isEqualTo(new HashSet<>(asList("foo", "ofo", "oof")));
        assertThat(anagrams.get("aabb")).isEqualTo(new HashSet<>(asList("abab", "baba")));
    }
}