package arrays.basic;

public class ThirdLargest {
    int thirdLargest(int a[], int n)
    {
        int max = -1;
        int secondMax = -1;
        int thirdMax = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = a[i];
            } else if (a[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = a[i];
            } else if (a[i] > thirdMax) {
                thirdMax = a[i];
            }
        }
        return thirdMax;
    }
}
