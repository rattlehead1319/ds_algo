package problems.easy.mathematics;

import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    primes[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                count++;
            }
        }
        return count;
    }
}
