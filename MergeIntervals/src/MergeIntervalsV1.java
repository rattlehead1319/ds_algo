import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervalsV1 {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval a = intervals.get(i);

            Interval lastMerged = null;
            int mergedLastIndex = mergedIntervals.size() - 1;
            if (mergedLastIndex >= 0) {
                lastMerged = mergedIntervals.get(mergedLastIndex);
            }

            if (i+1 < intervals.size()) {
                Interval b = intervals.get(i+1);
                if (b.start >= a.start && b.start <= a.end) {
                    mergedIntervals.add(new Interval(a.start, Math.max(a.end, b.end)));
                    i++;
                } else {
                    mergedIntervals.add(a);
                }
            } else if (lastMerged != null && a.start >= lastMerged.start && a.end <= lastMerged.end) {
                mergedIntervals.remove(lastMerged);
                mergedIntervals.add(new Interval(lastMerged.start, Math.max(lastMerged.end, a.end)));
            } else {
                mergedIntervals.add(a);
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervalsV1.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervalsV1.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervalsV1.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}