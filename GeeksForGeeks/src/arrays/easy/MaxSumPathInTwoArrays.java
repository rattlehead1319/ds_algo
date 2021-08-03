package arrays.easy;

public class MaxSumPathInTwoArrays {
    int maxPathSum(int ar1[], int ar2[]) {
        int m = ar1.length;
        int n = ar2.length;

        int i = 0;
        int j = 0;

        int sum1 = 0;
        int sum2 = 0;
        int res = 0;

        while (i < m && j < n) {

            if(ar1[i] < ar2[j]) {
                sum1 += ar1[i++];
            } else if (ar1[i] > ar2[j]) {
                sum2 += ar2[j++];
            } else {
                sum1 += ar1[i++];
                sum2 += ar2[j++];
                res += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
            }
        }

        while (i < m) {
            sum1 += ar1[i++];
        }
        while (j < n) {
            sum2 += ar2[j++];
        }
        res += Math.max(sum1, sum2);
        return res;
    }
}
