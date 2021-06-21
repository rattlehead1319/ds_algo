package problems.easy.mathematics;

public class SqrtX {
    public int mySqrt(int x) {
        //return mySol(x);
        return efficientSol(x);
    }

    private int mySol(int x) {
        long y = 1;
        while (y*y < Integer.MAX_VALUE && y*y <= x) {
            if (y*y == x) {
                return (int)y;
            }
            y *= 2;
        }
        y = y/2;
        while (y*y < Integer.MAX_VALUE && y*y <= x) {
            if (y*y == x) {
                return (int)y;
            }
            y++;
        }
        --y;
        return (int)y;
    }

    /****
     *
     * mySqrt(x) = 2 × mySqrt(x/4)
     * x << y means x * Math.pow(2, y)
     * x >> y means x / Math.pow(2, y)
     *
     ******/
    private int efficientSol(int x) {
        if (x < 2) {
            return x;
        }

        int left = efficientSol(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}
