package greedy.medium;

import java.util.*;

class Job {
    int id, deadline, profit;
    Job (int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobComparator implements Comparator<Job> {
    public int compare (Job a, Job b) {
        return b.profit - a.profit;
    }
}

public class JobSequencing {
    int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr, new JobComparator());

        int unitsOfWorkDone = 0;
        int profit = 0;
        int[] availableSlots = new int[n];
        int endIndex = n-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].deadline > endIndex) {
                profit += arr[i].profit;
                availableSlots[endIndex--] = arr[i].id;
                unitsOfWorkDone++;
            } else if (availableSlots[arr[i].deadline - 1] == 0) {
                profit += arr[i].profit;
                availableSlots[arr[i].deadline - 1] = arr[i].id;
                unitsOfWorkDone++;
            } else {
                int k = arr[i].deadline - 2;
                while (k >= 0) {
                    if (availableSlots[k] == 0) {
                        profit += arr[i].profit;
                        availableSlots[k] = arr[i].id;
                        unitsOfWorkDone++;
                        if (k == endIndex) {
                            endIndex--;
                        }
                        break;
                    }
                    k--;
                }
            }
        }
        return new int[]{unitsOfWorkDone, profit};
    }
}
