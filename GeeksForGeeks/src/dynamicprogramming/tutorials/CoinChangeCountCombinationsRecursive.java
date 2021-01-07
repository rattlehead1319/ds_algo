package dynamicprogramming.tutorials;

public class CoinChangeCountCombinationsRecursive {
    public static int getCount (int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        int res = getCount(coins, n-1, sum);
        if (coins[n-1] <= sum) {
            res += getCount(coins, n, sum - coins[n-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{1,2,3}, 3, 4));
    }
}
