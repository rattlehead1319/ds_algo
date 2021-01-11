package trie.medium;

import java.util.*;

public class CamelCase {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        List<String> words;
        TrieNode () {
            children = new TrieNode[ALPHABET_SIZE];
            words = new ArrayList<>();
        }
    }

    static TrieNode root;

    static void findAllWords(String[] dict, String pattern)
    {
        root = new TrieNode();
        TrieNode current;

        for (String word: dict) {
            current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLowerCase(c)) {
                    continue;
                }
                int index = c - 'A';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEnd = true;
            current.words.add(word);
        }

        current = root;
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'A';
            if (current.children[index] == null) {
                System.out.println("No match found");
                return;
            }
            current = current.children[index];
        }
        printAllWords(current);
    }

    static void printAllWords (TrieNode root) {
        if (root.isEnd) {
            for (String word : root.words) {
                System.out.print(word + " ");
            }
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            TrieNode next = root.children[i];
            if (next != null) {
                printAllWords(next);
            }
        }
    }
}
