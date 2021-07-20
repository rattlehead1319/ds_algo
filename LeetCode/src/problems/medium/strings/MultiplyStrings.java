package problems.medium.strings;

import java.util.*;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        List<String> rows = new ArrayList<>();

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        //swap num1 with num2 if its length is lesser than num2's length
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }

        int maxLength = Integer.MIN_VALUE;
        StringBuilder zeroes = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = Character.getNumericValue(num2.charAt(i));
            int carry = 0;
            StringBuilder sum = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = Character.getNumericValue(num1.charAt(j));
                int z = carry + x * y;
                carry = z / 10;
                sum.append(z % 10);
            }
            if (carry > 0) {
                sum.append(carry);
            }
            sum = sum.reverse();
            sum.append(zeroes);
            rows.add(sum.toString());

            maxLength = Math.max(maxLength, sum.length());
            zeroes.append("0");
        }

        StringBuilder result = new StringBuilder();
        int right = 0;
        int carry = 0;
        while (right < maxLength) {
            int sum = 0;
            for (String row : rows) {
                int index = row.length() - 1 - right;
                int x = 0;
                if (index >= 0) {
                    x = Character.getNumericValue(row.charAt(index));
                }
                sum += x;
            }
            result.append((sum + carry) % 10);
            carry = (sum + carry) / 10;
            right++;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
