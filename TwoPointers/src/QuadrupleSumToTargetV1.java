import java.util.*;

public class QuadrupleSumToTargetV1 {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            getTriQuadruplets(arr, i+1, target - arr[i], arr[i], quadruplets);
        }

        return quadruplets;
    }

    private static void getTriQuadruplets(int[] arr, int left, int target, int firstElement, List<List<Integer>> quadruplets) {
        for (int i = left; i < arr.length -2; i++) {
            getQuadruplets(arr, i+1, target - arr[i], firstElement, arr[i], quadruplets);
        }
    }

    private static void getQuadruplets(int[] arr, int left, int target, int firstElement,
                                       int secondElement,
                                       List<List<Integer>> quadruplets)
    {
        int right = arr.length -1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                quadruplets.add(Arrays.asList(firstElement, secondElement, arr[left], arr[right]));
                left++;
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTargetV1.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTargetV1.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
// -3,-1,1,1,2,4