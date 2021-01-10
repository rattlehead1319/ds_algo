package dynamicprogramming.medium;

public class CountWaysToNthStair_OrderDoesNotMatter {

    Long countWays(int m){
        long count = 1;
        while (m > 1) {
            count++;
            m = m-2;
        }

        return count;
    }
}
