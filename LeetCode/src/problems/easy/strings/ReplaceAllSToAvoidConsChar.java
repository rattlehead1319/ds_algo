package problems.easy.strings;

public class ReplaceAllSToAvoidConsChar {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int left = i - 1;
                while (i < s.length() && s.charAt(i) == '?') {
                    i++;
                }
                int right = i;
                int curr = right - 1;
                char c = 'a';
                while (curr > left) {
                    if ((left < 0 && right == s.length()) ||
                            (left >= 0 && c != s.charAt(left) && right < s.length() && c != s.charAt(right)) ||
                            (left < 0 && c != s.charAt(right)) ||
                            (right == s.length() && c != s.charAt(left))
                    )
                    {
                        sb.setCharAt(curr--, c++);
                    } else {
                        c++;
                    }
                    if (c == 'z') {
                        c = 'a';
                    }
                }
            }
        }
        return sb.toString();
    }
}
