package searching.basic;

public class MajorityElement {
    static int majorityElement(int a[], int size)
    {
        int count = 1;
        int res = 0;
        for (int i = 1; i < size; i++) {
            if (a[i] == a[res]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == a[res]) {
                count++;
            }
        }

        if (count > size/2) {
            return a[res];
        }
        return -1;
    }
}
