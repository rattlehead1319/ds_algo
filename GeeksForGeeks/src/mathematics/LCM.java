package mathematics;

public class LCM {

    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
