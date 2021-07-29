package problems.medium.trie;

public class ImplementTriePrefixTree {
    class Trie {
        Trie[] children;
        boolean isWord;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie curr = this;
            for (char x : word.toCharArray()) {
                if (curr.children[x - 'a'] == null) {
                    curr.children[x - 'a'] = new Trie();
                }
                curr = curr.children[x - 'a'];
            }
            curr.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie curr = this;
            for (char x : word.toCharArray()) {
                if (curr.children[x - 'a'] == null) {
                    return false;
                }
                curr = curr.children[x - 'a'];
            }
            return curr.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie curr = this;
            for (char x : prefix.toCharArray()) {
                if (curr.children[x - 'a'] == null) {
                    return false;
                }
                curr = curr.children[x - 'a'];
            }
            return true;
        }
    }
}
