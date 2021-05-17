package contest;

import java.util.*;
import java.lang.*;
import java.io.*;

public class TheConversionToOne {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(getSteps(n));
        }
    }

    private static int getSteps(int n) {

        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + getSteps(n/2);
        } else {
            return 1 + Math.min(getSteps(n-1), getSteps(n+1));
        }
    }
}
