package problems.easy.strings;

import java.util.*;

public class ReorderDataInLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String> digits = new LinkedList<>();
            List<Helper> lettersHelperList = new ArrayList<>();

            for (String log: logs) {
                String[] temp = log.split(" ");
                if (Character.isDigit(temp[1].charAt(0))) {
                    digits.add(log);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < temp.length; i++) {
                        sb.append(temp[i]);
                        if (i != temp.length - 1) {
                            sb.append(" ");
                        }
                    }
                    lettersHelperList.add(new Helper(temp[0], sb.toString()));
                }
            }
            Collections.sort(lettersHelperList);

            String[] result = new String[logs.length];
            int resultIndex = 0;
            for (Helper h : lettersHelperList) {
                StringBuilder sb = new StringBuilder(h.identifier);
                sb.append(" ");
                sb.append(h.content);
                result[resultIndex++] = sb.toString();
            }

            for (String digitLog : digits) {
                result[resultIndex++] = digitLog;
            }

            return result;
        }

        class Helper implements Comparable<Helper> {
            String identifier;
            String content;
            Helper(String identifier, String content) {
                this.identifier = identifier;
                this.content = content;
            }

            @Override
            public int compareTo(Helper h) {
                if (this.content.compareTo(h.content) == 0) {
                    return this.identifier.compareTo(h.identifier);
                }
                return this.content.compareTo(h.content);
            }
        }
    }
}
