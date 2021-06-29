package problems.medium.hashing;

import java.util.*;

//Hashmap + DoublyLinkedList is better implementation

public class LRUCache {
    private ArrayDeque<Integer> deque;
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        deque = new ArrayDeque<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            map.put(key, value);
            return;
        }
        if (deque.size() == capacity) {
            int leastUsed = deque.removeLast();
            map.remove(leastUsed);
        }
        deque.addFirst(key);
        map.put(key, value);
    }
}
