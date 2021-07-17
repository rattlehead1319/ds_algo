package problems.medium.greedy;

import java.util.*;

public class PartitionLabels {
    class Helper {
        int start;
        int end;
    }
    public List<Integer> partitionLabels(String s) {
        //return mySol(s);
        return lcSol(s);
    }

    private List<Integer> lcSol(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length();i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    private List<Integer> mySol(String s) {
        Map<Character, Helper> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Helper h = map.get(c);
                h.end = i;
            } else {
                Helper h = new Helper();
                h.start = i;
                h.end = i;
                map.put(c, h);
            }
        }
        List<Integer> list = new ArrayList<>();
        int currentWindow = -1;
        int start = 0;
        for (Map.Entry<Character, Helper> entry : map.entrySet()) {
            Helper h = entry.getValue();
            if (currentWindow == -1) {
                currentWindow = h.end;
            } else if (h.start < currentWindow) {
                currentWindow = Math.max(currentWindow, h.end);
            } else {
                list.add(currentWindow - start + 1);
                start = h.start;
                currentWindow = h.end;
            }
        }
        list.add(s.length() - start);
        return list;
    }
}
