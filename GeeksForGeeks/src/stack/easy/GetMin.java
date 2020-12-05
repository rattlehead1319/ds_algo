package stack.easy;

import java.util.*;

public class GetMin {
    static int min = -1;
    /* inserts elements of the array into
        stack and return the stackn*/
    public static Stack<Integer> _push(int arr[],int n)
    {
        Stack<Integer> st = new Stack<>();
        min = arr[0];
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                st.push(arr[i] - min);
                min = arr[i];
            } else {
                st.push(arr[i]);
            }
        }
        return st;
    }

    /* print minimum element of the stack each time
       after popping*/
    static void _getMinAtPop(Stack<Integer>s)
    {
        while (!s.isEmpty()) {
            System.out.print(min + " ");
            int x = s.pop();
            if (x < 0) {
                min = min - x;
            }
        }
    }
}
