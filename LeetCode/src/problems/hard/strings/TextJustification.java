package problems.hard.strings;

import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int currentLength = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            currentLength += word.length();

            if (currentLength + row.size() > maxWidth) {
                StringBuilder sb = new StringBuilder();
                currentLength -= word.length();
                int spaces = maxWidth - currentLength;
                int blocks = row.size() == 1 ? 1 : row.size() - 1;
                int spacePerBlocks = (int)Math.ceil((double)spaces/(double)blocks);

                for (String adjustedWord: row) {
                    sb.append(adjustedWord);
                    if (blocks > 0) {
                        int spaceLength = Math.min(spacePerBlocks, spaces);
                        for (int j = 0; j < spaceLength; j++) {
                            sb.append(" ");
                        }
                        spaces -= spaceLength;
                        blocks--;
                        spacePerBlocks = (int)Math.ceil((double)spaces/(double)blocks);
                    }
                }

                result.add(sb.toString());
                row = new ArrayList<>();
                currentLength = word.length();
            }
            row.add(word);
        }
        String lastRow = String.join(" ", row.stream().toArray(String[]::new));
        for (int i = lastRow.length(); i < maxWidth; i++) {
            lastRow += " ";
        }
        result.add(lastRow);
        return result;
    }
}
