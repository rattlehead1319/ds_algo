package problems.medium.trie;

import java.util.*;

class AddAndSearchWords {

    Trie root;

    /** Initialize your data structure here. */
    public AddAndSearchWords() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (char x: word.toCharArray()) {
            if (!node.children.containsKey(x)) {
                node.children.put(x, new Trie());
            }
            node = node.children.get(x);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = root;
        return search(word, node);
    }

    private boolean search(String word, Trie node) {
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (node.children.get(x) == null) {
                if (x == '.') {
                    for (char y : node.children.keySet()) {
                        if (search(word.substring(i + 1), node.children.get(y))) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(x);
            }
        }
        return node.isEnd;
    }
}

class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean isEnd = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * AddAndSearchWords obj = new AddAndSearchWords();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
