package challenge.jan.week1;

public class KthMissingPositiveNumber {
  public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int j = 0;
        while (i <= arr[arr.length - 1] || j < arr.length) {
            if (k == 0) {
                return i-1;
            }
            if (i == arr[j]) {
                j++; 
            } else {
                k--;
            }
            i++;
        }
        while (k-- > 0) {
            i++;
        }
        return i-1;
    }
}
