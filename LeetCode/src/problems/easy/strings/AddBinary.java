package problems.easy.strings;

public class AddBinary {
    public String addBinary(String a, String b) {
        Helper h = new Helper();
        StringBuilder sb = new StringBuilder("");
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            sb.append(getSum(a.charAt(aIndex--), b.charAt(bIndex--), h));
        }
        while (aIndex >= 0) {
            sb.append(getSum(a.charAt(aIndex--), '0', h));
        }
        while (bIndex >= 0) {
            sb.append(getSum(b.charAt(bIndex--), '0', h));
        }
        if (h.carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    private String getSum(char a, char b, Helper h) {
        int x = a - '0';
        int y = b - '0';
        int z = x + y + h.carry;
        if (z == 3) {
            h.carry = 1;
            return "1";
        } else if (z == 2) {
            h.carry = 1;
            return "0";
        }
        h.carry = 0;
        return String.valueOf(z);
    }

    private static class Helper {
        int carry = 0;
    }
}
