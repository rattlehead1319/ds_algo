package arrays.easy;

import java.util.Arrays;

public class MeanAndMedianOfArray {
    public int median(int A[],int N)
    {

        Arrays.sort(A);

        //Your code here
        //If median is fraction then conver it to integer and return
        return N%2 == 0 ? (A[N/2] + A[(N/2)-1])/2 : A[N/2];
    }

    public int mean(int A[],int N)
    {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }
        return sum/N;
    }
}
