import java.util.Arrays;
import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int res = 0, cnt = 0;
        int[] visited = new int[s.length()];
        Arrays.fill(visited, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int left = stack.pop();
                    visited[i] = 1;
                    visited[left] = 1;
                }
            }
        }
        for (int j : visited) {
            if (j != 0) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}
