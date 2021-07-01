package problems.medium.strings;

public class StringCompression {
    public int compress(char[] chars) {
        int start = 0;
        int end = 0;
        int charsIndex = 0;
        while (end < chars.length) {
            int count = 0;
            start = end;
            while (end < chars.length && chars[start] == chars[end]) {
                end++;
                count++;
            }
            chars[charsIndex++] = chars[start];
            if (count == 1) {
                continue;
            }
            String countString = "";
            while (count > 0) {
                countString += count % 10;
                count = count / 10;
            }
            countString = reverse(countString.toCharArray());
            for (char x : countString.toCharArray()) {
                chars[charsIndex++] = x;
            }
        }
        return charsIndex;
    }

    private String reverse(char[] chars) {
        String result = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            result += Character.toString(chars[i]);
        }
        return result;
    }
}
