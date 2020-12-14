package hashing.easy;

import java.util.*;

public class WinnerOfAnElection {
    public static String[] winner(String arr[], int n)
    {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String winner = "";
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                winner = entry.getKey();
            } else if (entry.getValue() == max) {
                String pw = entry.getKey();
                winner = winner.compareTo(pw) < 0 ? winner : pw;
            }
        }
        return new String[]{winner, String.valueOf(max)};
    }
}
