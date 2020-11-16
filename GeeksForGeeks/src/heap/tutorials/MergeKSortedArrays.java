package heap.tutorials;

import java.util.*;

class Helper {
    int val;
    int arrIndex;
    int valIndex;

    Helper(int val, int arrIndex, int valIndex) {
        this.val = val;
        this.arrIndex = arrIndex;
        this.valIndex = valIndex;
    }
}

public class MergeKSortedArrays {
    private List<Integer> merge(int[][] arr , int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Helper> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < arr.length; i++) { //O(nlogk)
            pq.add(new Helper(arr[i][0], i, 0));
        }

        //Atmost we have nk elements and we are adding and removing
        //so overall Time complexity would be O(nklogk)
        while (!pq.isEmpty()) {
            Helper h = pq.poll();
            result.add(h.val);
            int arrIndex = h.arrIndex;
            int valIndex = h.valIndex;
            if (valIndex + 1 < arr[arrIndex].length) {
                pq.add(new Helper(arr[arrIndex][valIndex + 1], arrIndex, valIndex +1));
            }
        }

        return result;
    }
}
