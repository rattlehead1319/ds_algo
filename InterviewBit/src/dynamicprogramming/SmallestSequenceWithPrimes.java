package dynamicprogramming;

import java.util.*;

public class SmallestSequenceWithPrimes {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> result = new ArrayList<>();
        if (D == 0) {
            return result;
        }

        TreeSet<Integer> factors = new TreeSet<>();
        factors.add(A);
        factors.add(B);
        factors.add(C);

        int j = 0;
        while (!factors.isEmpty()) {
            int curr = factors.pollFirst();
            result.add(curr);
            j++;
            if (j == D) {
                break;
            }
            factors.add(curr * A);
            factors.add(curr * B);
            factors.add(curr * C);
        }
        return result;
    }
}
