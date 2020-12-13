package strings.medium;

import java.util.Arrays;

public class CaseSpecificSorting {
    public static String caseSort(String str) {
        String lowers = "";
        String uppers = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                lowers += str.charAt(i);
            } else {
                uppers += str.charAt(i);
            }
        }

        lowers = sortString(lowers);
        uppers = sortString(uppers);

        String result = "";
        int lowerIndex = 0;
        int upperIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                result += lowers.charAt(lowerIndex++);
            } else {
                result += uppers.charAt(upperIndex++);
            }
        }
        return result;
    }

    private static String sortString (String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
