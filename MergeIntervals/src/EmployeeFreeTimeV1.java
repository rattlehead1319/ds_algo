import java.util.*;

class EmployeeFreeTimeV1 {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> merged = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < schedule.size() - 1; i++) {
            List<Interval> a = schedule.get(i);
            List<Interval> b = schedule.get(i+1);

            ListIterator<Interval> aItr = null;
            boolean isMergedIterator = false;
            if (merged.isEmpty()) {
                aItr = a.listIterator();
            } else {
                aItr = merged.listIterator();
                isMergedIterator = true;
            }
            ListIterator<Interval> bItr = b.listIterator();

            while (aItr.hasNext() && bItr.hasNext()) {
                Interval i1 = aItr.next();
                Interval i2 = bItr.next();

                if (i2.start <= i1.end) {
                    if (!isMergedIterator) {
                        merged.add(new Interval(i1.start, Math.max(i1.end, i2.end)));
                    } else {
                        aItr.set(new Interval(i1.start, Math.max(i1.end, i2.end)));
                    }
                } else {
                    if (!isMergedIterator) {
                        merged.add(new Interval(i1.start, i1.end));
                        merged.add(new Interval(i2.start, i2.end));
                    } else {
                        aItr.add(new Interval(i2.start, i2.end));
                    }
                }
            }
            while (aItr.hasNext()) {
                Interval i1 = aItr.next();
                if (!isMergedIterator) {
                    merged.add(new Interval(i1.start, i1.end));
                }
            }
            while (bItr.hasNext()) {
                Interval i2 = bItr.next();
                merged.add(new Interval(i2.start, i2.end));
            }
        }

        for (int i = 0; i < merged.size() - 1; i++) {
            Interval a = merged.get(i);
            Interval b = merged.get(i+1);
            result.add(new Interval(a.end, b.start));
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTimeV1.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTimeV1.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTimeV1.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
