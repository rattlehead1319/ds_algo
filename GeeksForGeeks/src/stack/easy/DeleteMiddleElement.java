package stack.easy;

import java.util.*;

public class DeleteMiddleElement {
    public void deleteMid(Stack<Integer>s,int sizeOfStack) {
        deleteMidRec(s, sizeOfStack, 0);
    }

    private void deleteMidRec (Stack<Integer> s, int n, int curr) {
        if (s.isEmpty() || n == curr) {
            return;
        }
        int x = s.pop();
        deleteMidRec(s, n, curr+1);
        if (curr != n/2) {
            s.push(x);
        }
    }
}
