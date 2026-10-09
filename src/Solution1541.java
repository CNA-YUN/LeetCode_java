public class Solution1541 {
    public int minInsertions(String s) {
        int n = s.length();
        int left = 0;
        int cnt = 0;
        for (int i = 0; i < n;) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
                i++;
            } else {
                if (i + 1 == n) {
                    if (left > 0) {
                        cnt++;
                        left--;
                    } else {
                        cnt += 2;
                    }
                    i++;
                    continue;
                }
                if (s.charAt(i + 1) == ')' && left > 0) {
                    left--;
                    i += 2;
                } else if (left > 0) {
                    left--;
                    cnt++;
                    i++;
                } else if (s.charAt(i + 1) == ')') {
                    cnt++;
                    i += 2;
                } else {
                    cnt += 2;
                    i++;
                }
            }
        }
        return cnt + 2 * left;
    }
}
