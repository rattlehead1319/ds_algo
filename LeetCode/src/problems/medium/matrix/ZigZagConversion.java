package problems.medium.matrix;

import java.util.*;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //return mySol(s, numRows);
        return betterSol(s, numRows);
    }

    private String betterSol(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(i, new StringBuilder());
        }

        boolean goingDown = false;
        int row = 0;
        for (char x : s.toCharArray()) {
            list.get(row).append(x);
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: list) {
            result.append(sb);
        }

        return result.toString();
    }

    private String mySol(String s, int numRows) {
        char[][] matrix = new char[numRows][s.length()];

        int i = 0;
        int j = 0;
        int index = 0;

        while (index < s.length()) {

            while (i < numRows && index < s.length()) {
                matrix[i++][j] = s.charAt(index++);
            }

            i = i - 2;
            j++;

            while (i > 0 && j < s.length() && index < s.length()) {
                matrix[i--][j++] = s.charAt(index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int p = 0; p < numRows; p++) {
            for (int q = 0; q < s.length(); q++) {
                if (matrix[p][q] != '\u0000') {
                    sb.append(matrix[p][q]);
                    count++;
                    if (count == s.length()) {
                        break;
                    }
                }
            }
            if (count == s.length()) {
                break;
            }
        }

        return sb.toString();
    }
}
