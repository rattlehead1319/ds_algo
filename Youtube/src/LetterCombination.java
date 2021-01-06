
import java.util.*;

public class LetterCombination {


    public List<String> letterCombination (String digits) {
        List<String> result = new ArrayList<>();
        String[] mapping = new String[]{
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationRecursive(result, digits, "", 0, mapping);
        return result;
    }

    private void letterCombinationRecursive (List<String> result, String digits, String current, int index,
                                             String[] mapping)
    {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationRecursive(result, digits, current + letters.charAt(i), index+1, mapping);
        }
    }
}
