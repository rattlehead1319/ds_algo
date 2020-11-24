package greedy.easy;

import java.util.*;

class Range implements Comparable<Range>{
    int start;
    int end;
    Range (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Range r) {
        return this.end - r.end;
    }
}

public class ActivitySelection {
    static int activitySelection(int start[], int end[], int n)
    {
        Range[] rangeArr = new Range[n];
        for (int i = 0; i < n; i++) {
            rangeArr[i] = new Range(start[i], end[i]);
        }

        Arrays.sort(rangeArr);

        int count = 1;
        int prevEnd = rangeArr[0].end;
        for (int i = 1; i < n; i++) {
            if (rangeArr[i].start >= prevEnd) {
                count++;
                prevEnd = rangeArr[i].end;
            }
        }

        return count;
    }
}
