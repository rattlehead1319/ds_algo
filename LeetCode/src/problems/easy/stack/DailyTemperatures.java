package problems.easy.stack;

import java.util.*;

public class DailyTemperatures {
    class Helper {
        int index;
        int value;
        Helper (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Helper> st = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            while (!st.isEmpty() && temp >= st.peek().value) {
                st.pop();
            }
            if (!st.isEmpty()) {
                result[i] = st.peek().index - i;
            }

            st.push(new Helper(i, temp));
        }

        return result;
    }
}
