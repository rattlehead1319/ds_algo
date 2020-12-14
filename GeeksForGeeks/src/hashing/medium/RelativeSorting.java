package hashing.medium;

import java.util.*;

public class RelativeSorting {
    static class Helper implements Comparable<Helper> {
        int data;
        int weight;

        Helper(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public int compareTo (Helper h) {
            return this.weight - h.weight;
        }
    }

    public static void sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            map.put(A2[i], i);
        }

        List<Helper> list = new ArrayList<>();
        List<Integer> restOfList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(A1[i])) {
                list.add(new Helper(A1[i], map.get(A1[i])));
            } else {
                restOfList.add(A1[i]);
            }
        }
        Collections.sort(list);
        Collections.sort(restOfList);

        int i = 0;
        for (i = 0; i < list.size(); i++) {
            A1[i] = list.get(i).data;
        }
        int j = 0;
        while (j < restOfList.size()) {
            A1[i++] = restOfList.get(j++);
        }
    }
}
