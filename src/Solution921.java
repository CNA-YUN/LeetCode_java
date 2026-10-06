import java.util.Stack;

public class Solution921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] carr = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = carr[i];
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    cnt++;
                    continue;
                }
                stack.pop();
            }
        }
        cnt += stack.size();
        return cnt;
    }
}
