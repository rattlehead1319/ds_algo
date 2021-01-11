package trie.medium;

import java.util.*;

public class RenamingCities {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode () {
            children = new TrieNode[ALPHABET_SIZE];
        }
    }

    static TrieNode root;

    public static void check(String arr[],int n)
    {

        root = new TrieNode();

        Map<String, Integer> map = new HashMap<>();

        for (String city: arr) {
            boolean hasPrinted = false;
            String toBePrinted = "";
            TrieNode current = root;

            for (int i = 0; i < city.length(); i++) {
                int index = city.charAt(i) - 'a';
                toBePrinted += city.charAt(i);
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                    if (!hasPrinted) {
                        System.out.println(toBePrinted);
                        hasPrinted = true;
                    }
                }
                current = current.children[index];
            }
            current.isEnd = true;

            map.put(city, map.getOrDefault(city, 0) + 1);
            if (!hasPrinted) {
                int count = map.get(city);
                if (count > 1) {
                    System.out.println(city + " " + count);
                } else {
                    System.out.println(city);
                }
            }
        }
    }
}
