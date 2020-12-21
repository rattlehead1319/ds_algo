package sorting.easy;

public class CountingSort {
    public static char[] countSort(char seq[])
    {
        int n = seq.length;
        int k = 26;

        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            int ci = Math.abs(97 - seq[i]);
            count[ci]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] = count[i-1] + count[i];
        }

        int[] out = new int[n];
        //This should be done in reverse order if we need to do stable sorting
        for (int i = 0; i < n; i++) {
            int ci = Math.abs(97 - seq[i]);
            out[count[ci]-1] = seq[i];
            count[ci]--;
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = (char)out[i];
        }

        return result;
    }
}
