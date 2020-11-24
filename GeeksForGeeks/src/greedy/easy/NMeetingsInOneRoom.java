package greedy.easy;

import java.util.*;

class Helper implements Comparable<Helper> {
    int start;
    int end;
    int index;
    Helper (int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo (Helper p) {
        return this.end - p.end;
    }
}

public class NMeetingsInOneRoom {
    static void maxMeetings(int start[], int end[], int n) {
        Helper[] items = new Helper[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Helper(start[i], end[i], i+1);
        }
        Arrays.sort(items);

        List<Integer> result = new ArrayList<>();
        result.add(items[0].index);
        Helper prev = items[0];
        for (int i = 1; i < n; i++) {
            if (items[i].start > prev.end) {
                result.add(items[i].index);
                prev = items[i];
            }
        }
        for (Integer val: result) {
            System.out.print(val + " ");
        }
    }
}
