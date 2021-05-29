package arrays.medium;

import java.sql.SQLOutput;
import java.util.*;

public class MaxInStack {

    private static Stack<Integer> stack = new Stack<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b - a
    );

    public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//
//        for (int i = 0; i < t; i++) {
//            String line = sc.nextLine();
//            String[] input = line.split(" ");
//            int operation = Integer.parseInt(input[0]);
//            int val = -1;
//            if (input.length == 2) {
//                val =  Integer.parseInt(input[1]);
//            }
//
//            int result = handle(operation, val);
//            if (operation == 3) {
//                System.out.println(result);
//            }
//        }

        String s1 = "SITHA";
        String s2 = "RAMA";
        System.out.println(s1.charAt(0) > s2.charAt(0));
    }

    private static int handle(int operation, int val) {
        switch (operation) {
            case 1:
                stack.push(val);
                pq.add(val);
                break;
            case 2:
                int x = stack.pop();
                if (!pq.isEmpty() && pq.peek() == x) {
                    pq.poll();
                }
                break;
            case 3:
                if (!pq.isEmpty()) {
                    return pq.peek();
                }
                break;
            default:
                return -1;
        }
        return -1;
    }
}
