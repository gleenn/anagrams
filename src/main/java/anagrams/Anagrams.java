package anagrams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static utils.FileUtils.readLines;

public class Anagrams {
    private Node root;

    public static void main(final String[] args) {
        final Anagrams anagrams = new Anagrams();
//        readLines(args[0], anagrams::add);
//        anagrams.getAll().stream().forEach(System.out::println);
        readLines(args[0], new Consumer<String>() {
            @Override
            public void accept(String word) {
                anagrams.add(word);
            }
        });
        for(Set<String> anagramSet : anagrams.getAll()) {
            System.out.println(anagramSet);
        }
    }

    public Anagrams() {
        this.root = new Node();
    }

    private LinkedList<String> wordToList(String word) {
        String[] chars = word.split("(?!^)");
        Arrays.sort(chars);
        return new LinkedList<>(asList(chars));
    }

    public void add(final String word) {
        add(root, wordToList(word), word);
    }

    void add(final Node current, final LinkedList<String> letters, final String word) {
        if(letters.size() == 0) return;
        String character = letters.removeFirst();

        Node next = current.children.get(character);
        if(next == null) {
            next = new Node();
            current.children.put(character, next);
        }

        if(letters.size() == 0) {
            next.words.add(word);
        }

        current.children.put(character, next);

        add(next, letters, word);
    }

    public Set<String> get(final String word) {
        return get(root, wordToList(word));
    }

    Set<String> get(final Node current, final LinkedList<String> letters) {
        if(letters.size() == 0) return current.words;
        return get(current.children.get(letters.removeFirst()), letters);
    }

    public Set<Set<String>> getAll() {
        Set<Set<String>> result = new HashSet<>();
        getAll(root, result);
        return result;
    }

    public void getAll(Node node, Set<Set<String>> result) {
        for(Map.Entry<String, Node> child : node.children.entrySet()) {
            Node childNode = child.getValue();
            if(childNode.words.size() > 1)
                result.add(childNode.words);
            getAll(childNode, result);
        }
    }
}