package twopointers;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (endIndex > startIndex) {
            int sum = arr[endIndex] + arr[startIndex];
            if (sum > targetSum) {
                endIndex--;
            } else if (sum < targetSum) {
                startIndex++;
            } else{
                return new int[] {startIndex, endIndex};
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
