package hashing.easy;

import java.util.*;

public class SeparateChaining {
    public static ArrayList<ArrayList<Integer>> separateChaining(int arr[], int n, int hashSize)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < hashSize; i++) {
            result.add(i, new ArrayList<>());
        }
        for (int i = 0 ; i< n; i++) {
            int index = arr[i] % hashSize;
            ArrayList<Integer> list = result.get(index);
            list.add(arr[i]);
        }
        return result;
    }
}
