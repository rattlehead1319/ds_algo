package backtrack.medium;

import java.util.*;

public class GenerateAllSubstrings {
    private List<String> generateSubstrings(String s) {

        List<String> result = new ArrayList<>();
        generateSubstringsRec(s, -1, "", result);
        return result;
    }

    private void generateSubstringsRec(String s, int index, String curr, List<String> result) {
        if (curr.length() > s.length()) {
            return;
        }
        result.add(curr);
        for (int i = index + 1; i < s.length(); i++) {
            curr += s.charAt(i);
            generateSubstringsRec(s, i, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateAllSubstrings gas = new GenerateAllSubstrings();
        List<String> substrings = gas.generateSubstrings("cab");
        substrings.forEach(System.out::println);
    }
}
