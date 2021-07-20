package problems.easy.hashing;

import java.util.*;

//Below Time complexity is O(logn) as a number have logn digits
//Space is logn as well

//Better algorithm would be Floyds Cycle Detection -> Time Complexity -> O(logn) and Space Complexity -> O(1)

//Even better algorithm is to have a static hashset -> 4, 16, 37, 58, 89, 145, 42, 20 because eventually its going to fall in this fixed circle if the sum is not 1

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        return findSquaredSum(n, visited);
    }

    private boolean findSquaredSum(int n, Set<Integer> visited) {
        int x = 0;
        while (n > 0) {
            int y = n % 10;
            n = n/10;
            x += y*y;
        }
        if (x == 1) {
            return true;
        }
        if (visited.contains(x)) {
            return false;
        }
        visited.add(x);
        return findSquaredSum(x, visited);
    }
}
