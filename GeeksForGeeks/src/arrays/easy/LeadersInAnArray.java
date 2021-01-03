package arrays.easy;

import java.util.*;

public class LeadersInAnArray {
    static ArrayList<Integer> leaders(int arr[], int n){

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[n-1]);

        int max = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                temp.add(arr[i]);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = temp.size()-1; i >= 0; i--) {
            result.add(temp.get(i));
        }
        return result;
    }
}
