package searching.medium;

public class SmallestPositiveMissingNumber {
    static int findMissing(int arr[], int size)
    {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 1) {
                count++;
                break;
            }
        }

        if (count == 0) {
            return 1;
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0 || arr[i] > size) {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            int a = Math.abs(arr[i]);
            arr[a - 1] = -Math.abs(arr[a - 1]);
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }
}
