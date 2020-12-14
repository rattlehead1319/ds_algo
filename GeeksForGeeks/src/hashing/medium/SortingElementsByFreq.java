package hashing.medium;

import java.util.*;

public class SortingElementsByFreq {
    static class Helper implements Comparable<Helper> {
        int data;
        int freq;
        Helper (int data, int freq) {
            this.data = data;
            this.freq = freq;
        }

        public int compareTo (Helper h) {
            if (h.freq == this.freq) {
                return this.data - h.data;
            }
            return h.freq - this.freq;
        }
    }
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Helper> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Helper(arr[i], map.get(arr[i])));
        }

        Collections.sort(list);

        ArrayList<Integer> result = new ArrayList<>();
        for (Helper h: list) {
            result.add(h.data);
        }

        return result;
    }
}
