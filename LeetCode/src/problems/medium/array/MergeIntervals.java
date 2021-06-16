package problems.medium.array;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //return leetcodeSol(intervals);
        return mySol(intervals);
    }

    private int[][] leetcodeSol(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private int[][] mySol(int[][] intervals) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> a.start - b.start
        );

        for (int[] interval: intervals) {
            pq.add(new Pair(interval[0], interval[1]));
        }

        List<Pair> result = new ArrayList<>();
        while (pq.size() > 1) {
            Pair current = pq.poll();
            Pair next = pq.peek();
            if (next.start > current.end) {
                result.add(current);
            } else {
                pq.poll();
                pq.add(new Pair(current.start, Math.max(current.end, next.end)));
            }
        }
        result.add(pq.poll());

        int[][] resultArr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            int[] sub = new int[2];
            sub[0] = result.get(i).start;
            sub[1] = result.get(i).end;
            resultArr[i] = sub;
        }

        return resultArr;
    }

    static class Pair {
        int start;
        int end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
