package anagrams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

import static java.util.Arrays.asList;
import static utils.FileUtils.readLines;

public class Anagrams {
    private Node root;

    public static void main(final String[] args) {
        readLines(args[0], System.out::println);
    }

    public Anagrams() {
        this.root = new Node();
    }

    public void add(final String word) {
        add(root, wordToList(word), word);
    }

    private LinkedList<String> wordToList(String word) {
        String[] chars = word.split("(?!^)");
        Arrays.sort(chars);
        return new LinkedList<>(asList(chars));
    }

    void add(final Node current, final LinkedList<String> letters, final String word) {
        if(letters.size() == 0) return;
        if(letters.size() == 1) {
            current.words.add(word);
            return;
        }
        String character = letters.removeFirst();
        Node next = current.children.get(character);
        if(next == null) {
            next = new Node();
            current.children.put(character, next);
        }
        add(next, letters, word);
    }

    public Set<String> get(final String word) {

        return get(root, wordToList(word));
    }

    Set<String> get(final Node current, final LinkedList<String> letters) {
        if(letters.size() == 1) return current.words;
        return get(current.children.get(letters.removeFirst()), letters);
    }
}