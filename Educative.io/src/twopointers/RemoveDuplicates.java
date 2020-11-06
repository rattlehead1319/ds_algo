package twopointers;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int start = 1;
        int nonDuplicate = 1;
        while (start < arr.length) {
            if (arr[nonDuplicate - 1] != arr[start]) {
                arr[nonDuplicate] = arr[start];
                nonDuplicate++;
            }
            start++;
        }
        return nonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
