package hashing.easy;

import java.util.*;

public class QuadraticProbing {
    static void quadraticProbing(int[] hash, int hash_size, int arr[], int N)
    {
        Arrays.fill(hash, -1);
        for (int i = 0; i < N; i++) {
            int h = arr[i] % hash_size;
            int count = 0;
            int j = 1;
            while (hash[h] != -1 && count < hash_size) {
                h = (arr[i] + j*j) % hash_size;
                j++;
                count++;
            }
            if (count == hash_size) {
                continue;
            }
            hash[h] = arr[i];
        }
    }
}
