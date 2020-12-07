package stack.medium;

import java.util.*;

public class TheCelebrityProblemV2 {
    int celebrity(int M[][], int n){
        Stack<Integer> st = new Stack<>();
        for (int i =0; i<n; i++){
            st.push(i);
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (M[a][b] == 1) {
                st.push(b);
            } else if(M[b][a] == 1) {
                st.push(a);
            }
        }
        int c = st.pop();
        for (int i = 0; i < n; i++) {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (M[c][i] == 1 || M[i][c] != 1)) {
                return -1;
            }
        }
        return c;
    }
}
