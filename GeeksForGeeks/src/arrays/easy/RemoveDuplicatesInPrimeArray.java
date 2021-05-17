package arrays.easy;

import java.util.*;

public class RemoveDuplicatesInPrimeArray {

    //this method works for less number of items in array
    ArrayList<Integer> removeDuplicate(int arr[], int n)
    {
        ArrayList<Integer> result = new ArrayList<>();
        long product = arr[0];
        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (product % (long)arr[i] != 0) {
                result.add(arr[i]);
                product *= arr[i];
            }
        }
        return result;
    }

    ArrayList<Integer> removeDuplicates(int arr[], int n)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!result.contains(arr[i])) {
                result.add(i);
            }
        }
        return result;
    }
}
