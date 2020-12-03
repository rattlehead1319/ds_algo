package backtrack.medium;

import java.util.*;

public class Subsets {
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr);
        permute(arr, 0, list, result);
        result.remove(0);
        return result;
    }

    private static void permute (int[] arr, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < arr.length; i++) {
            if (i == index || arr[i] != arr[i-1]) {
                list.add(arr[i]);
                permute(arr, i+1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
