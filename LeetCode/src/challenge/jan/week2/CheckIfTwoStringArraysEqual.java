package challenge.jan.week2;

public class CheckIfTwoStringArraysEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null && word2 == null) {
            return true;
        }
        if ((word1 == null && word2 != null) || (word1 != null && word2 == null)) {
            return false;
        }

        String sentence1 = "";
        for (String word : word1) {
            sentence1 += word;
        }

        String sentence2 = "";
        for (String word : word2) {
            sentence2 += word;
        }
        return sentence1.equals(sentence2);
    }
}
