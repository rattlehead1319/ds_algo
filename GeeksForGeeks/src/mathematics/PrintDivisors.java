package mathematics;

public class PrintDivisors {
    static void printDivisors(int n) {
        int i = 1;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        for (; i >= 1; i--) {
            if (n % i == 0) {
                System.out.print((n / i) + " ");
            }
        }
    }
}
