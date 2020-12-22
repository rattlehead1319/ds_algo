package searching.easy;

public class Count1sInBinaryArray {
    public static int countOnes(int arr[], int N){
        return bs(arr, 0, N-1);
    }

    private static int bs (int[] arr, int low, int high) {
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == 0) {
                high = mid-1;
            } else {
                if (mid == arr.length - 1 || arr[mid] != arr[mid+1]) {
                    return mid+1;
                } else {
                    low = mid+1;
                }
            }
        }
        return 0;
    }
}
