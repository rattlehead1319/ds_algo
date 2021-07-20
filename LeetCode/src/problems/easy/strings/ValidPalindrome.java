package problems.easy.strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                sb.append(Character.toLowerCase(x));
            } else if (Character.isDigit(x)) {
                sb.append(x);
            }
        }

        String s1 = sb.toString();
        int left = 0;
        int right = s1.length() - 1;

        while (left <= right) {
            if (s1.charAt(left) != s1.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
