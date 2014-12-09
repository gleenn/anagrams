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
        anagrams.add("a");
        anagrams.add("s");
        anagrams.add("foo");
        anagrams.add("ofo");
        anagrams.add("oof");
        anagrams.add("of");
        anagrams.add("of");
        anagrams.add("of");
        anagrams.add("abab");
        anagrams.add("baba");

        assertThat(anagrams.get("a")).isEqualTo(new HashSet<>(asList("a")));
        assertThat(anagrams.get("s")).isEqualTo(new HashSet<>(asList("s")));
        assertThat(anagrams.get("of")).isEqualTo(new HashSet<>(asList("of")));
        assertThat(anagrams.get("fo")).isEqualTo(new HashSet<>(asList("of")));
        assertThat(anagrams.get("foo")).isEqualTo(new HashSet<>(asList("foo", "ofo", "oof")));
        assertThat(anagrams.get("aabb")).isEqualTo(new HashSet<>(asList("abab", "baba")));

        assertThat(anagrams.getAll()).isEqualTo(new HashSet<>(asList(
                new HashSet<>(asList("abab", "baba")),
                new HashSet<>(asList("foo", "ofo", "oof")))));
    }

    @Test
    public void forReals() {
        Anagrams.main(new String[] {"/usr/share/dict/words"});
    }
}