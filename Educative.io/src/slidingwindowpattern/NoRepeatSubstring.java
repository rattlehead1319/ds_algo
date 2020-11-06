package slidingwindowpattern;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        // TODO: Write your code here
        int start = 0;
        int maxLength = 0;
        char prev = ' ';
        for (int end = 0; end < str.length();  end++) {
            char current = str.charAt(end);
            if (current == prev) {
                maxLength = Math.max(maxLength, end - start);
                start = end;
            }
            prev = current;
        }
        if (maxLength == 0) {
            maxLength = str.length();
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
