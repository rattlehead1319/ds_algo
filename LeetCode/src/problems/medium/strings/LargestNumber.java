package problems.medium.strings;

import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<Helper> list = new ArrayList<>();
        for (int num: nums) {
            list.add(new Helper(String.valueOf(num)));
        }

        Collections.sort(list);

        if (list.get(0).number.equals("0")) {
            return "0";
        }

        String result = "";
        for (Helper h: list) {
            result += h.number;
        }

        return result;
    }

    class Helper implements Comparable<Helper> {
        String number;
        Helper (String number) {
            this.number = number;
        }

        @Override
        public int compareTo(Helper h) {
            String x = this.number;
            String y = h.number;

            return (y + x).compareTo(x + y);
        }
    }
}
