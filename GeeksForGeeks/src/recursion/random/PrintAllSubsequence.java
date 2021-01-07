package recursion.random;

import java.util.*;

public class PrintAllSubsequence {
    public static void getAllSubsequence(String s, int index, String curr) {
        if (index == s.length()) {
            return;
        }
        System.out.println(curr);
        for (int i = index+1; i < s.length(); i++) {
            curr += s.charAt(i);
            getAllSubsequence(s, i, curr);
            curr = curr.substring(0, curr.length()-1);
        }
    }

    public static void main (String[] args) {
        String s = "ABCD";
        int index = -1;
        String curr = "";
        getAllSubsequence(s, index, curr);
    }
}
