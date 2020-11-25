package greedy.easy;

public class LargestNumberWithGivenSum {
    static String largestNumber(int n, int sum)
    {
        String result = "";

        while (n > 0) {
            if (sum > 9) {
                result += String.valueOf(9);
                sum -= 9;
            } else if (sum > 0) {
                result += String.valueOf(sum);
                sum = 0;
            } else {
                result += String.valueOf(0);
            }
            n--;
        }

        //not possible
        if (sum > 0) {
            return String.valueOf(-1);
        }

        return result;
    }
}
