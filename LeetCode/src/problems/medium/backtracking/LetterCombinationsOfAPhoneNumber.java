package problems.medium.backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

//        Map<Character, String> map = Map.of(
//                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
//                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
//        );
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterCombinations(digits, "", 0, map, result);
        return result;
    }

    private void letterCombinations(String digits, String path, int index,
                                    Map<Character, String> map, List<String> result)
    {
        if (path.length() == digits.length()) {
            result.add(path);
            return;
        }

        String numbers = map.get(digits.charAt(index));
        for (char ch : numbers.toCharArray()) {
            path += Character.toString(ch);

            letterCombinations(digits, path, index + 1, map, result);

            path = path.substring(0, path.length() -1);
        }
    }
}
