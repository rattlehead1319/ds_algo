package challenge;

import java.util.*;

public class CheckArrayFormation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], pieces[i]);
        }

        int i = 0;
        while (i < arr.length) {
            if (map.containsKey(arr[i])) {
                int[] valArr = (int[])map.get(arr[i]);
                int j = 0;
                while (j < valArr.length) {
                    if (arr[i++] != valArr[j++]) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
