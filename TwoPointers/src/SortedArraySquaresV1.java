public class SortedArraySquaresV1 {

    public static int[] makeSquares(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.pow(arr[i], 2);
        }
        int start = 0;
        int end = arr.length - 1;
        while (end > start) {
            if (arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquaresV1.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquaresV1.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquaresV1.makeSquares(new int[] { -2, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
