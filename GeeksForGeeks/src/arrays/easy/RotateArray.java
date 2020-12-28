package arrays.easy;

public class RotateArray {
    static void rotateArr(int arr[], int d, int n)
    {
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    static void reverse (int arr[], int low, int high) {
        int mid = (low + high)/2;
        int left = (high-low+1)%2 == 0 ? mid : mid - 1;
        int right = mid+1;

        while (left >= low && right <= high) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left--;
            right++;
        }
    }
}
