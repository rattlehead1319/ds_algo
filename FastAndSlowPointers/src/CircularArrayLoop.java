public class CircularArrayLoop {
    public static boolean loopExists(int[] arr) {

        int slow = 0;
        int fast = 0;
        while (true) {
            slow = checkArrayLimits(slow + arr[slow], arr);
            fast = checkArrayLimits(fast + arr[fast], arr);
            fast = checkArrayLimits(fast + arr[fast], arr);
            if (slow == fast) {
                break;
            }
        }

        int next = checkArrayLimits(slow + arr[slow], arr);
        while (next != slow) {
            if (arr[next] < 0) {
                return false;
            }
            next = checkArrayLimits(next + arr[next], arr);
        }

        return true;
    }

    private static int checkArrayLimits(int i, int[] arr) {
        if (i >= arr.length) {
            return  i - arr.length;
        } else if (i < 0) {
            return arr.length + i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
