package stack.basic;

import java.util.*;

public class OperationsOnStack {
    // Function to insert element to stack
    public static void insert(Stack<Integer> st, int x)
    {
        st.push(x);

    }

    // Function to pop element from stack
    public static void remove(Stack<Integer> st)
    {
        int x = st.pop();

    }

    // Function to return top of stack
    public static void headOf_Stack(Stack<Integer> st)
    {
        int x = st.peek();
        System.out.println(x + " ");
    }

    // Function to find the element in stack
    public static boolean find(Stack<Integer> st, int val)
    {
        boolean exists = false;

        Iterator<Integer> it = st.iterator();
        while (it.hasNext()) {
            if (it.next() == val) {
                exists = true;
                break;
            }
        }
        if(exists == true){
            return true;
        }
        else{
            return false;
        }

    }
}
