package problems.easy.strings;

public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        while (end < chars.length) {
            start = end;
            while (end < chars.length && s.charAt(end) != ' ') {
                end++;
            }
            reverse(chars, start, end - 1);
            end++;
        }
        StringBuilder sb = new StringBuilder();
        for (char x: chars) {
            sb.append(x);
        }
        return sb.toString();
    }

    private void reverse (char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
