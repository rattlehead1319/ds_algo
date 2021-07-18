package problems.easy.dp;

import java.util.*;

public class MinStack {
    List<Integer> list;
    List<Integer> dp;

    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<>();
        dp = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        if (dp.isEmpty()) {
            dp.add(val);
            return;
        }
        dp.add(Math.min(dp.get(dp.size() - 1), val));
    }

    public void pop() {
        list.remove(list.size() - 1);
        dp.remove(dp.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return dp.get(dp.size() - 1);
    }
}
