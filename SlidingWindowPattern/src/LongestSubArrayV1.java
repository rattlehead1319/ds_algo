public class LongestSubArrayV1 {
    public static int findLength(int[] arr, int k) {
        int startIndex = 0;
        int maxLength = 0;
        int countZeros = 0;
        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
            if (arr[endIndex] == 0) {
                countZeros++;
            }
            if (countZeros > k) {
                if (arr[startIndex] == 0) {
                    countZeros--;
                } else {
                    while (countZeros > k) {
                        startIndex++;
                        if (arr[startIndex] == 0) {
                            countZeros--;
                        }
                    }
                }
                startIndex++;
            }
            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubArrayV1.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(LongestSubArrayV1.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
