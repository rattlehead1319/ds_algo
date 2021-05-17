package contest;


import java.util.*;
import java.lang.*;
import java.io.*;

public class GetTheShadow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            getMissingNumbers(arr);
        }
    }

    private static void getMissingNumbers(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (temp[arr[i]-1] == 1) {
                System.out.print(arr[i] + " ");
            } else {
                temp[arr[i] - 1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0) {
                System.out.print(i+1);
            }
        }
        System.out.println();
    }
}
