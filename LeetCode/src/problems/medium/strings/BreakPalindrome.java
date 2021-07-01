package problems.medium.strings;

public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        int i = 0;
        int lastKnownAIndex = 0;

        while (i < n) {
            String copy = palindrome;
            StringBuilder sb = new StringBuilder(palindrome);
            if (sb.toString().charAt(i) != 'a') {
                sb.setCharAt(i, 'a');
            } else if (i != 0) {
                lastKnownAIndex = i;
                i++;
                continue;
            }
            if (!isPalindrome(sb.toString())) {
                return sb.toString();
            }
            i++;
        }

        if (lastKnownAIndex != 0) {
            StringBuilder sb = new StringBuilder(palindrome);
            sb.setCharAt(lastKnownAIndex, 'b');
            if (!isPalindrome(sb.toString())) {
                return sb.toString();
            }
        }

        return "";
    }

    private boolean isPalindrome(String s) {
        int mid = s.length()/2;
        int left = mid - 1;
        int right = s.length() % 2 == 0 ? mid : mid + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left--) != s.charAt(right++)) {
                return false;
            }
        }
        return true;
    }
}
