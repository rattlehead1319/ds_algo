package hashing.basic;

import java.util.*;

public class CheckIfTwoArraysAreEqual {
    public static boolean check(long arr[],long brr[],int n)
    {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(brr[i])) {
                return false;
            }
        }

        return true;
    }
}
