package mathematics;

public class TrailingZeroesInFactorial {
    int countTrailingZeros(int n) {
        int res = 0;
        for(int i = 5; i <= n; i = i * 5) {
            res = res + (n / i);
        }
        return res;
    }
}
