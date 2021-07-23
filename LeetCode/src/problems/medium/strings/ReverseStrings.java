package problems.medium.strings;

import java.util.*;

public class ReverseStrings {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        for (Character x : s.toCharArray()) {
            if (x != ' ') {
                curr.append(x);
            } else {
                if (curr.length() != 0) {
                    words.add(curr.toString());
                }
                curr = new StringBuilder();
            }
        }
        if (curr.length() != 0) {
            words.add(curr.toString());
        }
        Collections.reverse(words);
        return String.join(" ", words.stream().toArray(String[]::new));
    }
}
