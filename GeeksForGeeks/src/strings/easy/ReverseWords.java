package strings.easy;

public class ReverseWords {
    String reverseWords(String S) {
        String[] words = S.split("\\.");
        if (words.length == 0) {
            return "";
        }
        String result = words[words.length - 1];
        for (int i = words.length - 2; i >= 0; i--) {
            result += "." + words[i];
        }
        return result;
    }
}
