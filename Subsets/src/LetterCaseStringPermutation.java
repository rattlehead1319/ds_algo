import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    String oldString = permutations.get(j);
                    String newString = oldString.replace(c, Character.toUpperCase(c));
                    permutations.add(newString);
                }
            }
        }
        
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
