package ds.hard;
/*
 * Worth looking again
 * Tricky algo
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {

        int queriesSize = queries.length;
        long[] output = new long[n + 2];
        long max = Long.MIN_VALUE;
        for (int rowIndex = 0; rowIndex < queriesSize; rowIndex++) {
            int[] query = queries[rowIndex];
            int startIndex = query[0];
            int endIndex = query[1];
            int value = query[2];
            output[startIndex] += value;
            output[endIndex + 1] -= value;
        }
        for (int index = 0; index < n+1; index++) {
            output[index + 1] += output[index];
            max = Math.max(max, output[index]);
        }
        return max;
    }
}
