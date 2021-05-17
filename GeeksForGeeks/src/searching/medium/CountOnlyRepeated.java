package searching.medium;

import java.awt.Point;

public class CountOnlyRepeated {
    public static Point findRepeating(Integer arr[],int n)
    {
        if (arr.length == 0) {
            return new Point(0, 0);
        }

        int low = 0;
        int high = n-1;

        while (low < high) {
            int mid = (low+high)/2;

            if (arr[mid] >= arr[0] + mid) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        int count = n - (arr[n-1] - arr[0]);
        return new Point(arr[low], count);
    }
}
