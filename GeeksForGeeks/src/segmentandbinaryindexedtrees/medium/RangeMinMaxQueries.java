package segmentandbinaryindexedtrees.medium;

import java.util.*;

class PII {
    int first;
    int second;
}

public class RangeMinMaxQueries {
    public static PII getMinMax(PII st[], long arr[], int n, int qs, int qe)
    {
        return getMinMaxRec(st, qs, qe, 0, n-1, 0);
    }

    private static PII getMinMaxRec(PII[] st, int qs, int qe, int ss, int se, int si) {
        if (qs > se || qe < ss) {
            PII pii = new PII();
            pii.first = Integer.MAX_VALUE;
            pii.second = Integer.MIN_VALUE;
            return pii;
        }
        if (qs <= ss && qe >= se) {
            return st[si];
        }

        int mid = ss + (se - ss)/2;
        PII left = getMinMaxRec(st, qs, qe, ss, mid, 2*si+1);
        PII right = getMinMaxRec(st, qs, qe, mid+1, se, 2*si+2);

        PII pii = new PII();
        pii.first = Math.min(left.first, right.first);
        pii.second = Math.max(left.second, right.second);

        return pii;
    }

    //Function to return minimum and maximum of elements in range from index
//qs (quey start) to qe (query end).
    public static void updateValue(long arr[],PII st[],int n,int index,long new_val)
    {

        long diff = new_val - arr[index];
        arr[index] = new_val;
        updateValueRec(st, 0, n-1, index, 0, diff);
    }

    private static void updateValueRec(PII[] st, int ss, int se, int index, int si, long diff) {
        if (index < ss || index > se) {
            return;
        }

        st[si].first = st[si].first + (int)diff;
        st[si].second = st[si].second + (int)diff;

        if (ss < se) {
            int mid = ss + (se - ss)/2;
            updateValueRec(st, ss, mid, index, 2*si+1, diff);
            updateValueRec(st, mid+1, se, index, 2*si+2, diff);

            st[si].first = Math.min(st[2*si+1].first, st[2*si+2].first);
            st[si].second = Math.max(st[2*si+1].second, st[2*si+2].second);
        }
    }
}
