package problems.easy.array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        //return mySolution(digits);
        return betterSolution(digits);
    }

    private int[] betterSolution(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }

    private int[] mySolution(int[] digits) {
        int n = digits.length;
        boolean needNewArray = true;
        for (int i = 0; i < n; i++) {
            if (digits[i] != 9) {
                needNewArray = false;
                break;
            }
        }
        if (needNewArray) {
            int[] res = new int[n+1];
            res[0] = 1;
            return res;
        }

        int carry = 0;
        for (int i = n-1; i >= 0; i--) {
            if (i == n-1) {
                carry = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            } else {
                int x = digits[i];
                digits[i] = (carry + digits[i]) % 10;
                carry = (carry + x) / 10;
            }
        }
        return digits;
    }
}
