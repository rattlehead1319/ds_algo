package problems.medium.array;

public class LongestMountain {
    public int longestMountain(int[] arr) {
        int index = 0;
        int maxLength = 0;
        int currLength = 0;
        while (index + 1 < arr.length) {
            if (arr[index] < arr[index + 1]) {
                currLength = 1;
                while (index + 1 < arr.length && arr[index] < arr[index + 1]) {
                    index++;
                    currLength++;
                }
                if (index + 1 == arr.length || arr[index] == arr[index + 1])  {
                    currLength = 0;
                }

                while (index + 1 < arr.length && arr[index] > arr[index + 1]) {
                    index++;
                    currLength++;
                }
                maxLength = Math.max(currLength, maxLength);
                currLength = 0;
            } else {
                index++;
            }
        }

        return maxLength;
    }
}
