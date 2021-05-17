package arrays.medium;

public class SmallestPositiveMissingNumber {
    static int missingNumber(int arr[], int size)
    {
        int index = 0;
        for (index = 0; index< size; index++) {
            if (arr[index] == 1) {
                break;
            }
        }
        if (index == size) {
            return 1;
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0 || arr[i] > size) {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            arr[(arr[i] - 1) % size] = arr[(arr[i] - 1) % size] + size;
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] <= size) {
                return i+1;
            }
        }

        return size+1;
    }
}
