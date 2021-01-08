package dynamicprogramming.tutorials;

public class MinimumJumpsToReachEndV1 {
    public static int minJumps (int[] arr, int index) {
        if (index == arr.length - 1) {
            return 0;
        }

        int current = arr[index];
        int jumps = Integer.MAX_VALUE;
        for (int i = 1; i <= current; i++) {
            if (index + i < arr.length) {
                int x = minJumps(arr, index + i);
                if (x != Integer.MAX_VALUE) {
                   jumps = Math.min(jumps, x+1);
                }
            }
        }

        return jumps;
    }

    public static void main (String[] args) {
        System.out.println(minJumps(new int[]{4,1,5,3,1,3,2,1,8}, 0));
        System.out.println(minJumps(new int[]{3,4,2,1,2,1}, 0));
    }
}
