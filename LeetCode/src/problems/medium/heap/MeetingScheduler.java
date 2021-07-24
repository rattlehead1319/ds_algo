package problems.medium.heap;

import java.util.*;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> timeslots = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);

        for (int[] slot: slots1) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }
        for (int[] slot: slots2) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }

        while (timeslots.size() > 1) {
            int[] slot1 = timeslots.poll();
            int[] slot2 = timeslots.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<Integer>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<Integer>();
    }

    public List<Integer> minAvailableDuration1(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

         List<Integer> result = new ArrayList<>();
         int i = 0;
         int j = 0;
         while (i < slots1.length && j < slots2.length) {
             int slotStart = Math.max(slots1[i][0], slots2[j][0]);
             int slotEnd = Math.min(slots1[i][1], slots2[j][1]);
             if (slotEnd - slotStart >= duration) {
                 result.add(slotStart);
                 result.add(slotStart + duration);
                 return result;
             }
             if (slots2[j][1] < slots1[i][1]) {
                 j++;
             } else {
                 i++;
             }
         }

         return result;
    }
}
