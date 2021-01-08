package dynamicprogramming.tutorials;

public class Knapsack0_1Recursive {

    public static int knapsack(int[] v, int[] w, int W, int n) {

        if (n == 0) {
            return 0;
        }

        if (W == 0) {
            return 0;
        }

        if (w[n-1] > W) {
            return knapsack(v, w, W, n-1);
        } else {
            return Math.max(
                    knapsack(v, w, W, n-1),
                    v[n-1] + knapsack(v, w, W - w[n-1], n-1)
            );
        }
    }

    public static void main (String[] args) {
        System.out.println(knapsack(new int[]{10, 40, 30, 50}, new int[]{5, 4, 6, 3}, 10, 4));
    }
}
