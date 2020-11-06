package twoheaps;

import java.util.*;

class MaximizeCapital {
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        int capitalIndex = 0;
        while (capitalIndex < capital.length) {
            minHeap.add(capital[capitalIndex++]);
        }

        int availableCapital = initialCapital;
        while (numberOfProjects > 0) {
            while(!minHeap.isEmpty() && minHeap.peek() <= availableCapital) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            availableCapital += profits[maxHeap.poll()];
            numberOfProjects--;
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}