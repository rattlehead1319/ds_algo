package arrays.basic;

public class MinimumDistanceBetweenTwoNumbers {
    int minDist(int a[], int n, int x, int y) {

        int firstIndex = -1;
        int secondIndex = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                firstIndex = i;
            } else if (a[i] == y) {
                secondIndex = i;
            }
            if (firstIndex != -1 && secondIndex != -1) {
                res = Math.min(res, Math.abs(firstIndex - secondIndex));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
