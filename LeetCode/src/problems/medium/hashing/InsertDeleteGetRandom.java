package problems.medium.hashing;

import java.util.*;

public class InsertDeleteGetRandom {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElement = list.get(list.size()-1);

            list.set(index, lastElement);
            map.put(lastElement, index);

            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random = (int) (Math.random() * (list.size()));
        return list.get(random);
    }
}
