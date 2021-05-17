package arrays.medium;

public class RearrangeAnArrayWith01ExtraSpace {
    static void arrange(long arr[], int n)
    {
        long size = Long.valueOf(n);
        for (int i = 0; i < size; i++) {
            arr[i] += (arr[(int)arr[i]] % size) * size;
        }

        for (int i = 0; i < size; i++) {
            arr[i] = arr[i]/size;
        }
    }
}
