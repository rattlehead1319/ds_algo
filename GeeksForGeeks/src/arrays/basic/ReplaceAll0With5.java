package arrays.basic;

public class ReplaceAll0With5 {
    int convertfive(int num) {

        int res = 0;
        int pow = 0;
        while (num > 0) {
            int x = num % 10;
            if (x == 0) {
                x = 5;
            }
            res += Math.pow(10, pow) * x;
            pow++;
            num = num/10;
        }
        return res;
    }
}
