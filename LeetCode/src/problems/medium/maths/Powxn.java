package problems.medium.maths;

public class Powxn {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }

        double result = 1;
        double currResult = x;
        for (long i = N; i > 0; i = i/2) {
            if (i % 2 == 1) {
                result = currResult * result;
            }
            currResult = currResult * currResult;
        }
        return result;
    }
}
