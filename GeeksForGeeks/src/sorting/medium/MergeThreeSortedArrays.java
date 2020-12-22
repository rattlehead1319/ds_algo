package sorting.medium;

import java.util.*;

public class MergeThreeSortedArrays {
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        int a = A.length-1;
        int b = B.length-1;
        int c = C.length-1;

        int outCapacity = A.length+B.length+C.length;
        int outIndex = outCapacity-1;
        int[] out = new int[outCapacity];

        while (a >= 0 && b >= 0 && c >= 0) {
            if (A[a] > B[b]) {
                if (A[a] > C[c]) {
                    out[outIndex--] = A[a--];
                } else if (A[a] < C[c]) {
                    out[outIndex--] = C[c--];
                } else {
                    out[outIndex--] = A[a--];
                    out[outIndex--] = C[c--];
                }
            } else if (A[a] < B[b]) {
                if (B[b] > C[c]) {
                    out[outIndex--] = B[b--];
                } else if (B[b] < C[c]) {
                    out[outIndex--] = C[c--];
                } else {
                    out[outIndex--] = B[b--];
                    out[outIndex--] = C[c--];
                }
            } else {
                if (A[a] == C[c]) {
                    out[outIndex--] = C[c--];
                    out[outIndex--] = A[a--];
                    out[outIndex--] = B[b--];
                } else if (C[c] > A[a]) {
                    out[outIndex--] = C[c--];
                } else {
                    out[outIndex--] = A[a--];
                    out[outIndex--] = B[b--];
                }
            }
        }

        while (b >= 0 && c >= 0) {
            if (B[b] > C[c]) {
                out[outIndex--] = B[b--];
            } else if (B[b] < C[c]) {
                out[outIndex--] = C[c--];
            } else {
                out[outIndex--] = B[b--];
                out[outIndex--] = C[c--];
            }
        }

        while (b >= 0 && a >= 0) {
            if (B[b] > A[a]) {
                out[outIndex--] = B[b--];
            } else if (B[b] < A[a]) {
                out[outIndex--] = A[a--];
            } else {
                out[outIndex--] = B[b--];
                out[outIndex--] = A[a--];
            }
        }

        while (a >= 0 && c >= 0) {
            if (A[a] > C[c]) {
                out[outIndex--] = A[a--];
            } else if (A[a] < C[c]) {
                out[outIndex--] = C[c--];
            } else {
                out[outIndex--] = A[a--];
                out[outIndex--] = C[c--];
            }
        }

        while (a >= 0) {
            out[outIndex--] = A[a--];
        }

        while (b >= 0) {
            out[outIndex--] = B[b--];
        }

        while (c >= 0) {
            out[outIndex--] = C[c--];
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < outCapacity; i++) {
            result.add(out[i]);
        }
        return result;
    }
}
