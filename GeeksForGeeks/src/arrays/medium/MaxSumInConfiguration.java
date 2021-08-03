package arrays.medium;

public class MaxSumInConfiguration {
    int max_sum(int A[], int n)
    {
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += A[i];
        }

        int currValue = 0;
        for (int i = 0; i < n; i++) {
            currValue += i * A[i];
        }

        int maxValue = currValue;

        for(int i = 1; i < n; i++) {
            int nextValue = currValue - (currSum - A[i - 1]) + A[i - 1] * (n - 1);
            currValue = nextValue;
            maxValue = Math.max(nextValue, maxValue);
        }

        return maxValue;
    }
}
