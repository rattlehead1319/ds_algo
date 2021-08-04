package searching.medium;

public class SquareRoot {
    long floorSqrt(long x)
    {
        long low = 1;
        long high = x;
        long res = -1;

        while (low <= high) {
            long mid = (low+high)/2;
            long sq = mid*mid;

            if (sq == x) {
                return mid;
            } else if (sq > x) {
                high = mid-1;
            } else {
                low = mid+1;
                res = mid;
            }
        }

        return res;
    }
}
