package segmentandbinaryindexedtrees.medium;

public class RangeSumQueries {
    static void updateValue(int arr[], long st[], int n, int index, int val)
    {
        int diff = val- arr[index];
        arr[index] = val;
        updateValueRec(st, 0, n-1, index, 0, diff);
    }

    private static void updateValueRec(long[] st, int ss , int se, int i, int si, int diff) {
        if (i < ss || i > se) {
            return;
        }
        st[si] = st[si] + Long.valueOf(diff);

        if (se > ss) {
            int mid = (ss + se) / 2;
            updateValueRec(st, ss, mid, i, 2*si + 1, diff);
            updateValueRec(st, mid+1, se, i, 2*si + 2, diff);
        }
    }

    //Function to return sum of elements in range from index qs (query start)
//to qe (query end).
    public static long getSum(long st[], int n, int l, int r)
    {
        return getSumRec(st, l, r, 0, n-1, 0);
    }

    private static long getSumRec(long[] st, int qs, int qe, int ss, int se, int si) {
        if (qs > se || qe < ss) {
            return 0;
        }

        if (qs <= ss && qe >= se) {
            return st[si];
        }

        int mid = ss + (se - ss)/2;

        return getSumRec(st, qs, qe, ss, mid, 2*si + 1) + getSumRec(st, qs, qe, mid+1, se, 2*si+2);
    }
}
