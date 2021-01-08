package dynamicprogramming.tutorials;

public class EggDroppingPuzzleDP {

    private static int minTrials (int f, int e) {
        int[][] dp = new int[f+1][e+1];

        for (int i = 1; i <= e; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= f; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= f; i++) {
            for (int j = 2; j <= e; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            1 + Math.max(dp[x-1][j-1], dp[i-x][j])
                    );
                }
            }
        }

        return dp[f][e];
    }

    public static void main (String[] args) {
        System.out.println(minTrials(10, 2));
    }
}
