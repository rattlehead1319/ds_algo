import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoadV1 {

    public static int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs, Comparator.comparingInt(a -> a.start));
        Job a = jobs.get(0);
        int start = a.start, end = a.end;
        int max = Integer.MIN_VALUE;
        boolean conflicting = false;

        for (int i = 1; i <jobs.size(); i++) {
            Job b = jobs.get(i);
            if (b.start >= start && b.start < end) {
                if (!conflicting) {
                    max = Math.max(max, a.cpuLoad + b.cpuLoad);
                } else {
                    max = max + b.cpuLoad;
                }
                conflicting = true;
            } else {
                max = Math.max(max, b.cpuLoad);
                conflicting = false;
            }
            start = Math.max(a.start, b.start);
            end = Math.min(a.end, b.end);
            a = b;
        }

        return max;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoadV1.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoadV1.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoadV1.findMaxCPULoad(input));
    }
}
