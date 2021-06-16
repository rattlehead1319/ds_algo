package problems.medium.array;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newIntervals = new int[n+1][2];

        int intervalsIndex = 0;
        int newIntervalsIndex = 0;
        while (intervalsIndex < n && intervals[intervalsIndex][0] < newInterval[0]) {
            newIntervals[newIntervalsIndex++] = intervals[intervalsIndex++];
        }
        newIntervals[newIntervalsIndex++] = newInterval;
        while (newIntervalsIndex < n+1) {
            newIntervals[newIntervalsIndex++] = intervals[intervalsIndex++];
        }

        LinkedList<int[]> merged = new LinkedList<>();

        for (int i = 0; i < newIntervals.length; i++) {
            if (i == 0 || newIntervals[i][0] > merged.getLast()[1]) {
                merged.add(newIntervals[i]);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], newIntervals[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
