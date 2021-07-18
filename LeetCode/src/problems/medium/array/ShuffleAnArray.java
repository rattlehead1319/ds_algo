package problems.medium.array;

import java.util.*;

public class ShuffleAnArray {
    private int[] original;

    public ShuffleAnArray(int[] nums) {
        original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = new int[original.length];
        int shuffledIndex = 0;
        Set<Integer> recorded = new HashSet<>();
        while (shuffledIndex < original.length) {
            int index = new Random().nextInt(original.length);
            if (!recorded.contains(index)) {
                shuffled[shuffledIndex++] = original[index];
                recorded.add(index);
            }
        }

        return shuffled;
    }
}
