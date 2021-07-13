package problems.medium.trie;

import java.util.*;

public class SearchSuggestionsSystem {
    private Trie root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();
        insert(root, products);
        return search(root, searchWord);
    }

    private void insert(Trie current, String[] products) {
        for (String product: products) {
            current = root;
            for (char x: product.toCharArray()) {
                int key = x - 'a';
                if (current.children[key] == null) {
                    current.children[key] = new Trie();
                }
                current = current.children[key];
                //current.treeSet.add(product);
            }
            current.isWord = true;
        }
    }

    private List<List<String>> search(Trie root, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for (char x: searchWord.toCharArray()) {
            prefix += x;
            result.add(getSuggestions(prefix));
        }
        return result;
    }

    private List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        Trie current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return suggestions;
            }
            current = current.children[c - 'a'];
        }
        dfsWithPrefix(current, prefix, suggestions);
        return suggestions;
    }

    private void dfsWithPrefix(Trie current, String word, List<String> suggestions) {
        if (suggestions.size() == 3) {
            return;
        }
        if (current.isWord) {
            suggestions.add(word);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (current.children[c - 'a'] != null) {
                dfsWithPrefix(current.children[c - 'a'], word + c, suggestions);
            }
        }
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
        //TreeSet<String> treeSet = new TreeSet<>();
    }
}
