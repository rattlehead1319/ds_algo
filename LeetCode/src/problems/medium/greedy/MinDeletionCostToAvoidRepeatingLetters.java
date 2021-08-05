package problems.medium.greedy;

public class MinDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int max = cost[0];
        int sum = cost[0];
        char prev = s.charAt(0);
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                max = Math.max(max, cost[i]);
                sum += cost[i];
            } else {
                result += sum - max;
                sum = max = cost[i];
            }
            prev = curr;
        }
        result += sum - max;

        return result;
    }
}
