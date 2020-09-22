import java.util.*;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i <arr.length - 2; i++) {
            if (arr[i] >= 0 || (i > 0 && arr[i] == arr[i-1])) {// skip same element to avoid duplicate triplets
                continue;
            }
            getTriplets(arr, -arr[i], i+1, triplets);
        }

        return triplets;
    }

    private static void getTriplets(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length -1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left-1]) {// skip same element to avoid duplicate triplets
                    left++;
                }
                while (left < right && arr[right] == arr[right+1]) {// skip same element to avoid duplicate triplets
                    right--;
                }
            } else if (currentSum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

}
//-3,-2,-1,0,1,1,2
//-5,-2,-1,2,3