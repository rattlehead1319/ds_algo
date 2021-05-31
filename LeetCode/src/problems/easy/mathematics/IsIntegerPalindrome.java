package problems.easy.mathematics;

public class IsIntegerPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int divisor = 1;
        while (x / divisor >= 10) {
            divisor *= 10;
        }

        while (x != 0) {
            int leading = x/divisor;
            int trailing = x%10;

            if (leading != trailing) {
                return false;
            }

            x = (x % divisor) / 10;

            divisor = divisor/100;
        }

        return true;
    }
}
