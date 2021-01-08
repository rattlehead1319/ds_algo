package dynamicprogramming.tutorials;

public class MinimumJumpsToReachEndV2 {

    public static int minJumps (int[] arr, int n) {

        if (n == 1) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n-2; i++) {
            if (i + arr[i] >= n-1) {
                int x = minJumps(arr, i+1);
                if (x != Integer.MAX_VALUE) {
                    res = Math.min(res, x+1);
                }
            }
        }

        return res;
    }

    public static void main (String[] args) {
        System.out.println(minJumps(new int[]{4,1,5,3,1,3,2,1,8}, 9));
        System.out.println(minJumps(new int[]{3,4,2,1,2,1}, 6));
    }
}
