package contest;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Pattern {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String input = sc.nextLine();
            String pattern = sc.nextLine();

            int hash = 0;
            for (int i = 0; i < pattern.length(); i++) {
                int x = pattern.charAt(i);
                int val = Math.abs(96 - x);
                hash += val;
            }

            int subHash = 0;
            Set<Integer> set = new HashSet<>();
            int left = 0;
            int right = 1;

            while (left != input.length() - 1) {
                if (right == input.length() - 1 && right - left + 1 < pattern.length()) {
                    break;
                } else if (right == input.length()) {
                    break;
                }
                if (!set.contains(left)) {
                    int x = input.charAt(left);
                    int xVal = Math.abs(96 - x);
                    subHash += xVal;
                    set.add(left);
                }
                if (!set.contains(right)) {
                    int x = input.charAt(right);
                    int xVal = Math.abs(96 - x);
                    subHash += xVal;
                    set.add(right);
                }
                if (subHash < hash) {
                    right++;
                } else if (subHash > hash) {
                    int x = input.charAt(left);
                    int xVal = Math.abs(96 - x);
                    subHash -= xVal;
                    left++;
                } else if (right - left + 1 == pattern.length()) {
                    int k = left;
                    while (k <= right) {
                        System.out.print(input.charAt(k));
                        k++;
                    }
                    System.out.print(" " + left);
                    System.out.println();

                    int z = input.charAt(left);
                    int zVal = Math.abs(96 - z);
                    subHash -= zVal;
                    left++;

                    right++;
                } else {
                    int z = input.charAt(left);
                    int zVal = Math.abs(96 - z);
                    subHash -= zVal;
                    left++;

                    right++;
                }
            }
        }
    }
}
