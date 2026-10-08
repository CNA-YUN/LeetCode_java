import java.util.Stack;

public class Solution1021 {
    public String removeOuterParentheses(String s) {
        if (s == null || s.isEmpty()) return "";
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int depth = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                depth++;
                if (depth > 1) {
                    dp[i]++;
                }
            } else if (chars[i] == ')') {
                depth--;
                if (depth > 0) {
                    dp[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > 0) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
