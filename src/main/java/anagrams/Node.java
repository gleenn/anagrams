package anagrams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
    Set<String> words;
    Map<String, Node> children;

    public Node() {
        this.words = new HashSet<>();
        this.children = new HashMap<>();
    }
}
