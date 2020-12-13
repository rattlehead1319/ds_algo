package hashing.easy;

import java.util.*;

public class LinearProbing {
    static int[] linearProbing(int hash_size, int arr[], int N)
    {
        int[] result = new int[hash_size];
        Arrays.fill(result, -1);

        for (int i = 0; i < N; i++) {
            int hash = arr[i] % hash_size;
            if (result[hash] == -1) {
                result[hash] = arr[i];
            } else {
                int count = 0;
                while (result[hash] != -1 && count < hash_size) {
                    hash++;
                    hash = hash % hash_size;
                    count++;
                }
                if (count == hash_size) {
                    continue;
                }
                result[hash] = arr[i];
            }
        }

        return result;
    }
}
