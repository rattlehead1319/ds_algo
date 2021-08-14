package problems.medium.hashing;

import java.util.*;

public class FirstUniqueNumber {
    private Set<Integer> setQueue = new LinkedHashSet<>();
    private Map<Integer, Boolean> isUnique = new HashMap<>();

    public FirstUniqueNumber(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (!setQueue.isEmpty()) {
            return setQueue.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        //Case 1: This value is not yet in the data structure.
        //        It should be ADDED.
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            setQueue.add(value);
            // Case 2: This value has been seen once, so is now becoming
            // non-unique. It should be REMOVED.
        } else if (isUnique.get(value)) {
            isUnique.put(value, false);
            setQueue.remove(value);
        }
    }
}
